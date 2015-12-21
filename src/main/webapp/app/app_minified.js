var a=angular.module("mainApp",["ngRoute","ui.bootstrap"]);a.config(["$routeProvider",function(a){a.when("/clientes",{templateUrl:"views/clientes.html",controller:"clientesController"}).when("/medicos",{templateUrl:"views/medicos.html",controller:"medicosController"}).when("/orcamentos",{templateUrl:"views/orcamentos.html",controller:"orcamentoController"}).when("/produtos",{templateUrl:"views/produtos.html",controller:"produtosController"}).when("/servicos",{templateUrl:"views/servicos.html",controller:"servicosController"}).when("/usuarios",{templateUrl:"views/usuarios.html",controller:"usuariosController"}).when("/empresa",{templateUrl:"views/empresa.html",controller:"empresaController"}).otherwise({redirectTo:"/orcamentos"})}]),a.controller("clientesController",function(a,b){a.cliente={},a.showSuccessAlert=!1,a.showErrorAlert=!1,a.listarClientes=function(){b.get("api/v1/clientes").then(function(b){a.clientes=b.data})},a.listarClientes(),a.excluir=function(c){b["delete"]("api/v1/clientes/"+c).then(function(b){a.clientes=b.data})},a.create=function(){var c={nome:a.cliente.nome,cpf:a.cliente.cpf,endereco:a.cliente.endereco,bairro:a.cliente.bairro,cidade:a.cliente.cidade,estado:a.cliente.estado,cep:a.cliente.cep,telefone:a.cliente.telefone,email:a.cliente.email};b.post("api/v1/clientes/",c).success(function(b,c){a.clientes=b,a.cliente={},a.showSuccessAlert=!0,a.showErrorAlert=!1}).error(function(b,c){a.showErrorAlert=!0,a.showSuccessAlert=!1})}}),a.controller("empresaController",function(a,b){a.showSuccessAlert=!1,a.showErrorAlert=!1,a.empresa={},a.getEmpresa=function(){b.get("api/v1/empresas/mockId").then(function(b){a.empresa=b.data})},a.getEmpresa(),a.excluir=function(a){b["delete"]("api/v1/empresas/"+a).then(function(a){})},a.editar=function(){var c={nome:a.empresa.nome,cnpj:a.empresa.cnpj,endereco:a.empresa.endereco,bairro:a.empresa.bairro,cidade:a.empresa.cidade,estado:a.empresa.estado,cep:a.empresa.cep,telefone:a.empresa.telefone,email:a.empresa.email};b.put("api/v1/empresas/",c).success(function(b,c){a.empresa=b,a.showSuccessAlert=!0,a.showErrorAlert=!1}).error(function(b,c){a.showErrorAlert=!0,a.showSuccessAlert=!1})}}),a.controller("orcamentoController",function(a,b){b.get("api/v1/orcamentos").then(function(b){a.orcamentos=b.data}),a.exportToPDF=function(){window.open("reportServlet","_blank")},a.items=[],a.select={},a.plus=function(b){a.items[b].quantidade=a.items[b].quantidade+1},a.minus=function(b){a.items[b].quantidade=a.items[b].quantidade-1,0==a.items[b].quantidade&&a.items.splice(b,1)},a.clientes=[],a.listarClientes=function(){b.get("api/v1/clientes").then(function(b){a.clientes=b.data})},a.listarClientes(),a.produtos=[],a.listarProdutos=function(){b.get("api/v1/produtos").then(function(b){a.produtos=b.data})},a.listarProdutos(),a.addProduto=function(){if(!angular.isUndefined(a.select.produto)&&""!=a.select.produto){var b=JSON.parse(a.select.produto);for(var c in a.items)if(a.items[c].codigo===b.codigo)return void(a.items[c].quantidade=a.items[c].quantidade+1);b.quantidade=1,a.items.push(b)}},a.listarServicos=function(){b.get("api/v1/servicos").then(function(b){a.servicos=b.data})},a.listarServicos(),a.addServico=function(){if(!angular.isUndefined(a.select.servico)&&""!=a.select.servico){var b=JSON.parse(a.select.servico);for(var c in a.items)if(a.items[c].codigo===b.codigo)return void(a.items[c].quantidade=a.items[c].quantidade+1);b.quantidade=1,a.items.push(b)}},a.$watch("items",function(){a.totalGeral=0;for(var b in a.items)console.log("i: "+b),a.totalGeral=a.totalGeral+a.items[b].valorUnitario*a.items[b].quantidade},function(){}),a.minDate=new Date,a.maxDate=new Date(2020,5,22),a.dt=new Date,a.dt_orc=new Date,a.status={opened:!1},a.status_orc={opened:!1},a.open=function(b){a.status.opened=!0},a.open_orc_dt=function(b){a.status_orc.opened=!0}}),a.controller("produtosController",function(a,b){a.produto={},a.showSuccessAlert=!1,a.showErrorAlert=!1,a.listarProdutos=function(){b.get("api/v1/produtos").then(function(b){a.produtos=b.data})},a.listarProdutos(),a.excluir=function(c){b["delete"]("api/v1/produtos/"+c).then(function(b){a.produtos=b.data})},a.create=function(){var c={codigo:a.produto.codigo,descricao:a.produto.descricao,unidade:a.produto.unidade,valorUnitario:a.produto.valorUnitario,fabricante:a.produto.fabricante};b.post("api/v1/produtos/",c).success(function(b,c){a.produtos=b,a.produto={},a.showSuccessAlert=!0,a.showErrorAlert=!1}).error(function(b,c){a.showErrorAlert=!0,a.showSuccessAlert=!1})}}),a.controller("servicosController",function(a,b){a.servico={},a.showSuccessAlert=!1,a.showErrorAlert=!1,a.listarServicos=function(){b.get("api/v1/servicos").then(function(b){a.servicos=b.data})},a.listarServicos(),a.excluir=function(c){b["delete"]("api/v1/servicos/"+c).then(function(b){a.servicos=b.data})},a.create=function(){var c={codigo:a.servico.codigo,descricao:a.servico.descricao,unidade:a.servico.unidade,valorUnitario:a.servico.valorUnitario,fornecedor:a.servico.fornecedor};b.post("api/v1/servicos/",c).success(function(b,c){a.servicos=b,a.servico={},a.showSuccessAlert=!0,a.showErrorAlert=!1}).error(function(b,c){a.showErrorAlert=!0,a.showSuccessAlert=!1})}}),a.controller("usuariosController",function(a,b){a.usuario={},a.showSuccessAlert=!1,a.showErrorAlert=!1,a.listarUsuarios=function(){b.get("api/v1/usuarios").then(function(b){a.usuarios=b.data})},a.listarUsuarios(),a.excluir=function(c){b["delete"]("api/v1/usuarios/"+c).then(function(b){a.usuarios=b.data})},a.create=function(){var c={nome:a.usuario.nome,login:a.usuario.login,senha:a.usuario.senha};b.post("api/v1/usuarios/",c).success(function(b,c){a.usuarios=b,a.usuario={},a.showSuccessAlert=!0,a.showErrorAlert=!1}).error(function(b,c){a.showErrorAlert=!0,a.showSuccessAlert=!1})},a.update=function(a){}});