#language: pt
#encoding: utf-8
#@run
Funcionalidade: Funcionalidade de pesquisa no ecommerce

  Contexto:
    Dado que estou na página inicial do ecommerce

  @run
  Cenario: Realizar uma pesquisa sem informar o termo
    Quando realizo uma pesquisa por ""
    Então o sistema deve apresentar resultados relacionados ou uma mensagem apropriada

  Esquema do Cenario: Realizar pesquisa por diferentes termos
    Quando realizo uma pesquisa por "<termo_de_pesquisa>"
    Então o sistema deve apresentar resultados relevantes
    Exemplos:
      | termo_de_pesquisa |
      | camiseta          |
      | tênis             |
      | mochila           |
      | relógio           |