<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="${pageContext.request.contextPath}"><i class="bi bi-house"></i>&nbsp;Home</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
							aria-expanded="false" aria-label="Toggle navigation">
							
			  <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-1">
					
					<li class="nav-item">
					  <a class="nav-link" href="${pageContext.request.contextPath}/do/posicao">
							<i class="bi bi-graph-up"></i>&nbsp;Carteira</a>
					</li>
					<li class="nav-item">
					  <a class="nav-link" href="${pageContext.request.contextPath}/do/ordem/compra">
							<i class="bi bi-cart2"></i>&nbsp;Comprar</a>
					</li>
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Empresa
					  </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/empresa/new">Cadastrar Empresa</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/empresa/list">Listar Empresas</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/setor/new">Cadastrar Setor</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/setor/list">Listar Setores</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/setor/invest/list">Setores Investidos</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/instituicao/new">Cadastrar Instituição</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/instituicao/list">Instituições</a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Título
					  </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/titulo/new">Cadastrar</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/titulo/list">Listar</a></li>
						</ul>
					</li>
					<li class="nav-item">
					  <a class="nav-link" href="${pageContext.request.contextPath}/do/movs">
							<i class="bi bi-arrow-left-right"></i>&nbsp;Movimentação</a>
					</li>
					<li class="nav-item">
					  <a class="nav-link" href="${pageContext.request.contextPath}/do/situacao">
							<i class="bi bi-coin"></i>&nbsp;Situação</a>
					</li>
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Ganhos
					  </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/provento/new">Registrar Provento</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/provento/list">Listar Proventos</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/do/vendas/list">Listar Vendas</a></li>
							
						</ul>
					</li>
					
					<li class="nav-item">
					  <a class="nav-link" href="${pageContext.request.contextPath}/do/monitor">
						Monitorar
					  </a>
					</li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>