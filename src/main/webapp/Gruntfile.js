module.exports = function( grunt ) {

  grunt.initConfig({

    uglify : {
      options : {
        mangle: {toplevel: true},
    	squeeze: {dead_code: false},
    	codegen: {quote_keys: true}
      },

      my_target : {
        files : {
          'app/app_minified.js' : 
		[ 'app/app.js',
		'app/controllers/clientesController.js',  
		'app/controllers/empresaController.js',  
		'app/controllers/orcamentoController.js',  
		'app/controllers/produtosController.js',  
		'app/controllers/servicosController.js',  			
		'app/controllers/usuariosController.js'
		]
        }
      }
    } // uglify

  });


  // Plugins do Grunt
  grunt.loadNpmTasks( 'grunt-contrib-uglify' );


  // Tarefas que serão executadas
  grunt.registerTask( 'default', [ 'uglify' ] );

};
