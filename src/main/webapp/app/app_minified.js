var mainApp=angular.module("mainApp",["ngRoute","ui.bootstrap"]);mainApp.config(["$routeProvider",function($routeProvider){$routeProvider.when("/clientes",{templateUrl:"views/clientes.html",controller:"clientesController"}).when("/medicos",{templateUrl:"views/medicos.html",controller:"medicosController"}).when("/orcamentos",{templateUrl:"views/orcamentos.html",controller:"orcamentoController"}).when("/produtos",{templateUrl:"views/produtos.html",controller:"produtosController"}).when("/servicos",{templateUrl:"views/servicos.html",controller:"servicosController"}).when("/usuarios",{templateUrl:"views/usuarios.html",controller:"usuariosController"}).when("/empresa",{templateUrl:"views/empresa.html",controller:"empresaController"}).otherwise({redirectTo:"/orcamentos"})}]),mainApp.controller("clientesController",function($scope,$http){$scope.cliente={},$scope.showSuccessAlert=!1,$scope.showErrorAlert=!1,$scope.listarClientes=function(){$http.get("api/v1/clientes").then(function(response){$scope.clientes=response.data})},$scope.listarClientes(),$scope.excluir=function(cpf){$http["delete"]("api/v1/clientes/"+cpf).then(function(response){$scope.clientes=response.data})},$scope.create=function(){var data={nome:$scope.cliente.nome,cpf:$scope.cliente.cpf,endereco:$scope.cliente.endereco,bairro:$scope.cliente.bairro,cidade:$scope.cliente.cidade,estado:$scope.cliente.estado,cep:$scope.cliente.cep,telefone:$scope.cliente.telefone,email:$scope.cliente.email};$http.post("api/v1/clientes/",data).success(function(data,status){$scope.clientes=data,$scope.cliente={},$scope.showSuccessAlert=!0,$scope.showErrorAlert=!1}).error(function(data,status){$scope.showErrorAlert=!0,$scope.showSuccessAlert=!1})}}),mainApp.controller("empresaController",function($scope,$http){$scope.showSuccessAlert=!1,$scope.showErrorAlert=!1,$scope.empresa={},$scope.getEmpresa=function(){$http.get("api/v1/empresas/mockId").then(function(response){$scope.empresa=response.data})},$scope.getEmpresa(),$scope.excluir=function(codigo){$http["delete"]("api/v1/empresas/"+codigo).then(function(response){})},$scope.editar=function(){var data={nome:$scope.empresa.nome,cnpj:$scope.empresa.cnpj,endereco:$scope.empresa.endereco,bairro:$scope.empresa.bairro,cidade:$scope.empresa.cidade,estado:$scope.empresa.estado,cep:$scope.empresa.cep,telefone:$scope.empresa.telefone,email:$scope.empresa.email};$http.put("api/v1/empresas/",data).success(function(response,status){$scope.empresa=response,$scope.showSuccessAlert=!0,$scope.showErrorAlert=!1}).error(function(response,status){$scope.showErrorAlert=!0,$scope.showSuccessAlert=!1})}}),mainApp.controller("orcamentoController",function($scope,$http){$scope.orcamento={},$scope.items=[],$scope.clientes=[],$scope.select={},$scope.produtos=[],$scope.servicos=[],$scope.totalGeral=0,$scope.empresa,$scope.novoOrcamento=function(){$scope.orcamento={},$scope.items=[],$scope.clientes=[],$scope.select={},$scope.produtos=[],$scope.servicos=[],$scope.totalGeral=0,$scope.dt=new Date,$scope.dt_orc=new Date,$scope.clearAlertFlags(),$scope.disabilitarEdicao=!1},$scope.clearAlertFlags=function(){$scope.showFrontErrorAlert=!1,$scope.showSuccessAlert=!1,$scope.showErrorAlert=!1},$scope.detalhes=function(orc){$scope.orcamento=orc,$scope.orcamento.cliente=JSON.stringify(orc.cliente),$scope.items=orc.items,$scope.op="cadastrar",$scope.disabilitarEdicao=!0},$scope.refreshOrcList=function(){$http.get("api/v1/orcamentos").then(function(response){$scope.orcamentos=response.data})},$scope.refreshOrcList(),$http.get("api/v1/empresas/mockId").then(function(response){$scope.empresa=response.data}),$scope.excluir=function(codigo){$http["delete"]("api/v1/orcamentos/"+codigo).then(function(response){$scope.orcamentos=response.data})};var validacaoFront=function(){return $scope.showFrontErrorAlert=!1,angular.isUndefined($scope.orcamento.vendedor)?($scope.showFrontErrorAlert=!0,$scope.frontErrorMessage="Vendedor inválido!"):angular.isUndefined($scope.orcamento.validade)?($scope.showFrontErrorAlert=!0,$scope.frontErrorMessage="Validade inválida!"):angular.isUndefined($scope.orcamento.dataentrega)?($scope.showFrontErrorAlert=!0,$scope.frontErrorMessage="Data da entrega inválida!"):angular.isUndefined($scope.orcamento.dataorcamento)?($scope.showFrontErrorAlert=!0,$scope.frontErrorMessage="Data do orcamento inválida!"):angular.isUndefined($scope.orcamento.cliente)?($scope.showFrontErrorAlert=!0,$scope.frontErrorMessage="Cliente inváildo!"):angular.isUndefined($scope.items)?($scope.showFrontErrorAlert=!0,$scope.frontErrorMessage="Items inválidos!"):angular.isUndefined($scope.empresa)&&($scope.showFrontErrorAlert=!0,$scope.frontErrorMessage="Os dados da empresa devem ser definidos antes de gerar um relatório. Acesse o menu empresa e preencha os dados."),!$scope.showFrontErrorAlert},getOrcamento=function(){return{codigo:$scope.orcamento.codigo,vendedor:$scope.orcamento.vendedor,validade:$scope.orcamento.validade,dataentrega:$scope.orcamento.dataentrega,dataorcamento:$scope.orcamento.dataorcamento,empresa:$scope.empresa,cliente:JSON.parse($scope.orcamento.cliente),items:$scope.items}};$scope.create=function(){if(0!=validacaoFront()){var data=getOrcamento();$http.post("api/v1/orcamentos/",data).success(function(data,status){$scope.orcamento.codigo=data.codigo,$scope.showSuccessAlert=!0,$scope.showErrorAlert=!1}).error(function(data,status){$scope.showSuccessAlert=!1,$scope.showErrorAlert=!0})}};var exportPDFSubmit=function(codigo){var mapForm=document.createElement("form");mapForm.target="Map",mapForm.method="POST",mapForm.action="reportServlet";var mapInput=document.createElement("input");mapInput.type="text",mapInput.name="codigo",mapInput.value=codigo,mapForm.appendChild(mapInput),document.body.appendChild(mapForm),mapForm.submit()};$scope.exportToPDF=function(){if(0!=validacaoFront()){var data=getOrcamento();angular.isUndefined(data.codigo)?$http.post("api/v1/orcamentos",data).success(function(response){exportPDFSubmit(response.codigo),$scope.orcamento.codigo=response.codigo,$scope.showSuccessAlert=!0,$scope.showErrorAlert=!1}).error(function(data,status){$scope.showSuccessAlert=!1,$scope.showErrorAlert=!0}):exportPDFSubmit(data.codigo)}},$scope.plus=function(index){$scope.items[index].quantidade=$scope.items[index].quantidade+1},$scope.minus=function(index){$scope.items[index].quantidade=$scope.items[index].quantidade-1,0==$scope.items[index].quantidade&&$scope.items.splice(index,1)},$scope.listarClientes=function(){$http.get("api/v1/clientes").then(function(response){$scope.clientes=response.data})},$scope.listarClientes(),$scope.listarProdutos=function(){$http.get("api/v1/produtos").then(function(response){$scope.produtos=response.data})},$scope.listarProdutos(),$scope.addProduto=function(){if(!angular.isUndefined($scope.orcamento.produto)&&""!=$scope.orcamento.produto){var produto=JSON.parse($scope.orcamento.produto);for(var i in $scope.items)if($scope.items[i].codigo===produto.codigo)return void($scope.items[i].quantidade=$scope.items[i].quantidade+1);produto.quantidade=1,$scope.items.push(produto)}},$scope.listarServicos=function(){$http.get("api/v1/servicos").then(function(response){$scope.servicos=response.data})},$scope.listarServicos(),$scope.addServico=function(){if(!angular.isUndefined($scope.orcamento.servico)&&""!=$scope.orcamento.servico){var servico=JSON.parse($scope.orcamento.servico);for(var i in $scope.items)if($scope.items[i].codigo===servico.codigo)return void($scope.items[i].quantidade=$scope.items[i].quantidade+1);servico.quantidade=1,$scope.items.push(servico)}},$scope.$watch("items",function(){for(var i in $scope.items)$scope.totalGeral=$scope.totalGeral+$scope.items[i].valorUnitario*$scope.items[i].quantidade},function(){}),$scope.formatNumberSize=function(a){return(1e5+a+"").slice(-5)},$scope.minDate=new Date,$scope.maxDate=new Date(2020,5,22),$scope.dt=new Date,$scope.dt_orc=new Date,$scope.status={opened:!1},$scope.status_orc={opened:!1},$scope.open=function($event){$scope.status.opened=!0},$scope.open_orc_dt=function($event){$scope.status_orc.opened=!0}}),mainApp.controller("produtosController",function($scope,$http){$scope.produto={},$scope.showSuccessAlert=!1,$scope.showErrorAlert=!1,$scope.listarProdutos=function(){$http.get("api/v1/produtos").then(function(response){$scope.produtos=response.data})},$scope.listarProdutos(),$scope.excluir=function(codigo){$http["delete"]("api/v1/produtos/"+codigo).then(function(response){$scope.produtos=response.data})},$scope.create=function(){var data={codigo:$scope.produto.codigo,descricao:$scope.produto.descricao,unidade:$scope.produto.unidade,valorUnitario:$scope.produto.valorUnitario,fabricante:$scope.produto.fabricante};$http.post("api/v1/produtos/",data).success(function(data,status){$scope.produtos=data,$scope.produto={},$scope.showSuccessAlert=!0,$scope.showErrorAlert=!1}).error(function(data,status){$scope.showErrorAlert=!0,$scope.showSuccessAlert=!1})}}),mainApp.controller("servicosController",function($scope,$http){$scope.servico={},$scope.showSuccessAlert=!1,$scope.showErrorAlert=!1,$scope.listarServicos=function(){$http.get("api/v1/servicos").then(function(response){$scope.servicos=response.data})},$scope.listarServicos(),$scope.excluir=function(codigo){$http["delete"]("api/v1/servicos/"+codigo).then(function(response){$scope.servicos=response.data})},$scope.create=function(){var data={codigo:$scope.servico.codigo,descricao:$scope.servico.descricao,unidade:$scope.servico.unidade,valorUnitario:$scope.servico.valorUnitario,fornecedor:$scope.servico.fornecedor};$http.post("api/v1/servicos/",data).success(function(data,status){$scope.servicos=data,$scope.servico={},$scope.showSuccessAlert=!0,$scope.showErrorAlert=!1}).error(function(data,status){$scope.showErrorAlert=!0,$scope.showSuccessAlert=!1})}}),mainApp.controller("usuariosController",function($scope,$http){$scope.usuario={},$scope.showSuccessAlert=!1,$scope.showErrorAlert=!1,$scope.listarUsuarios=function(){$http.get("api/v1/usuarios").then(function(response){$scope.usuarios=response.data})},$scope.listarUsuarios(),$scope.excluir=function(login){$http["delete"]("api/v1/usuarios/"+login).then(function(response){$scope.usuarios=response.data})},$scope.create=function(){var data={nome:$scope.usuario.nome,login:$scope.usuario.login,senha:$scope.usuario.senha};$http.post("api/v1/usuarios/",data).success(function(data,status){$scope.usuarios=data,$scope.usuario={},$scope.showSuccessAlert=!0,$scope.showErrorAlert=!1}).error(function(data,status){$scope.showErrorAlert=!0,$scope.showSuccessAlert=!1})},$scope.update=function(usuario){}});