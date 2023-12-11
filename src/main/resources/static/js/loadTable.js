/**
 * 
 */
document.addEventListener("DOMContentLoaded", function() {
    const itemsPerPage = 15; // Número de itens por página
    const maxPagesDisplayed = 10; // Número máximo de páginas exibidas na paginação
    let currentPage = 1;

    // Função para renderizar a paginação
    function renderPagination(totalPages) {
        const pagination = document.getElementById("pagination");
        pagination.innerHTML = "";

        const startPage = Math.max(1, currentPage - Math.floor(maxPagesDisplayed / 2));
        const endPage = Math.min(totalPages, startPage + maxPagesDisplayed - 1);

        for (let i = startPage; i <= endPage; i++) {
            const li = document.createElement("li");
            li.className = `page-item ${i === currentPage ? 'active' : ''}`;
            li.innerHTML = `<a class="page-link" href="#" onclick="changePage(${i})">${i}</a>`;
            pagination.appendChild(li);
        }

        // Adiciona botões "anterior" e "próximo"
        if (currentPage > 1) {
            const prevLi = document.createElement("li");
            prevLi.className = "page-item";
            prevLi.innerHTML = `<a class="page-link" href="#" onclick="changePage(${currentPage - 1})">&laquo;</a>`;
            pagination.insertBefore(prevLi, pagination.firstChild);
        }

        if (currentPage < totalPages) {
            const nextLi = document.createElement("li");
            nextLi.className = "page-item";
            nextLi.innerHTML = `<a class="page-link" href="#" onclick="changePage(${currentPage + 1})">&raquo;</a>`;
            pagination.appendChild(nextLi);
        }

        if (maxPagesDisplayed < totalPages) {
            const inputLi = document.createElement("li");
            inputLi.className = "page-item";
            inputLi.innerHTML = `<input type="number" id="pagination_pg" class="page-link ms-4 w-75" onchange="changePage(this.value)" placeHolder="Página" max="${totalPages}" min="1">`;
            pagination.appendChild(inputLi);
        }
        document.getElementById("pagination_pg").value = currentPage;
        try{
        	Array.from(document.querySelectorAll(".page-link")).filter(el => el.textContent === `${currentPage}`)[0].parentNode.classList.add("active");
        } catch(e){}
    }

    // Função para fazer a solicitação AJAX e atualizar a tabela e a paginação
    function fetchData(page) {
		try{
			if(page > parseInt(document.getElementById("pagination_pg").max)){
				return;
			}
		} catch(e){};
		
		load();
		let pEndpoint = getEndPoint();
		pEndpoint = `${pEndpoint}`.indexOf("?") > -1 ? `${pEndpoint}&` : `${pEndpoint}?`;
        fetch(`${pEndpoint}offset=${--page}&limit=${itemsPerPage}`)
            .then(response => response.json())
            .then(data => {
                renderTable(data.content);
                renderPagination(data.totalPages);
            })
            .catch(error => console.error("Erro ao obter dados:", error));
    }

    // Função chamada ao clicar em uma página da paginação
    document.changePage = function(page) {
        currentPage = page;
        fetchData(page);
    }
    
	function getEndPoint(){
		let pEndpoint = `${endpoint}`.indexOf("?") > -1 ? `${endpoint}&` : `${endpoint}?`;
		const formSearch = document.querySelector('form[name=search]');
		if(formSearch != null){
			const fd = new FormData(formSearch);
			const params = new URLSearchParams(fd);
			pEndpoint += `${params.toString()}`; 
		}
		return pEndpoint;
	}

	try {
		document.querySelector('form[name=search]').addEventListener('submit', function(e){
			e.preventDefault();
			fetchData(1);
			return false;
		});
	} catch(e){console.log(e)}

    fetchData(currentPage);
});

function load(){
	const tbodyHeight = document.getElementById("report-body").clientHeight
	document.getElementById("report-body").innerHTML = 
		`<tr>
			<td class="text-center align-middle" colspan="11" style="height:`+tbodyHeight+`px">
  				<div class="spinner-border" role="status" style="width: 5rem; height: 5rem;">
    				<span class="visually-hidden">Loading...</span>
  				</div>
  			</td>
		</tr>`;
}

const param = new URLSearchParams(window.location.search);
function getParameter(key){
	return param.get(key)
}

function formatDate(date){
	if(date == '' || date == undefined){
		return '';
	}
	try {
		let sDate = new Date(date).toLocaleDateString();
		let sTime = new Date(date).toLocaleTimeString();
		return sDate + ' ' + sTime;
	} catch(e){
		console.log(e);
	}
}