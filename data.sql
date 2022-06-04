use db_lojagames;

insert into tb_categorias(tipo) values ("Ação");
insert into tb_categorias(tipo) values ("Terror");

insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("12", "2015-02-12", "Em sua mais nova aventura no universo de Marvel's Spider-man, o adolescente Miles Morales está se ajustando a sua nova casa, enquanto segue os passos de seu mentor, Peter Parker, como o novo Homem-aranha. Mas quando uma luta feroz pelo poder ameaça destruir sua nova casa, o aspirante a herói percebe que com grandes poderes, também deve vir uma grande responsabilidade. Para salvar toda a Nova Iorque da Marvel, Miles deve assumir o manto do Homem-Aranha e torná-lo seu.", true, 50, "https://images-submarino.b2w.io/produtos/01/00/img/1459449/0/1459449098_1GG.jpg", "PS4", 99.90, 3, "Game The Last Of Us Part Ii", 1);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("16", "2014-02-12", "Explore terras distantes, enfrente máquinas maiores e mais imponentes, e encontre nov", true, 995, "https://images-submarino.b2w.io/produtos/01/00/img/3892169/7/3892169791_1GG.jpg", "PS4", 211.90, 6, "Game Horizon Forbidden West", 1);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("14", "2019-02-12", "Você está pronto para desafiar o seu destino? Busque sua fortuna e deixe sua marca na história em UNCHARTED", true, 440, "https://images-submarino.b2w.io/produtos/01/00/img/4455139/6/4455139666_1GG.jpg", "PS5", 119.00, 2, "Game Uncharted: Coleção Legado Dos Ladrões", 1);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("12", "2021-02-12", "Em sua mais nova aventura no universo de Marvel's Spider-man, o adolescente Miles Morales ", true, 220, "https://images-submarino.b2w.io/produtos/01/00/img7/01/00/item/2751078/7/2751078757_1GG.jpg", "PS5", 199.90, 9, "Game Marvel's Spider-Man: Miles Morales", 1);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("16", "2018-06-12", "Encontre seu caminho! Curta a experiência completa do verdadeiro simulador de corridas... com 25 ", true, 532, "https://images-submarino.b2w.io/produtos/01/00/img/4032028/6/4032028673_1GG.jpg", "PS5", 119.00, 2, "Game Uncharted: Coleção Legado Dos Ladrões", 1);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("18", "2021-02-12", "Estados Unidos, 1899. O fim da era do velho oeste começou, e as autoridades estão caçando as últimas gangues de fora da lei que restam. Imagens meramente ilustrativ", true, 550, "https://images-submarino.b2w.io/produtos/01/00/img/133806/7/133806753_1GG.jpg", "PS4", 119.90, 4, "Game - Red Dead Redemption 2", 1);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("14", "2018-02-12", "Exploração do mundo nas Terras Intermédias: ELDEN RING apresenta vastos cenários fantásticos e complexas e esc", true, 115.99, "https://m.media-amazon.com/images/I/61zAbNEgqrL._AC_SX679_.jpg", "XBOX360", 199.90, 9, "Elden Ring - Padrão - Xbox Series X", 1);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("18", "2019-02-12", "A história de Back 4 Blood se passa após um surto apocalíptico em que a maior parte da humanidade foi dizimada ou infectada pelo par", true, 219.99, "https://images-americanas.b2w.io/produtos/4162145341/imagens/jogo-back-4-blood-br-xbox-one/4162145341_1_xlarge.jpg", "xbox360", 55.90, 9, "Jogo Back 4 Blood - Xbox", 2);
insert into tb_produtos(classificacao_indicativa, data_lancamento, descricao, disp, espaco_hd, foto, plataforma, preco, qtd, titulo, categoria_id) values ("16", "2018-02-12", "O jogo God of War Hits é o relançamento do clássico jogo de ação e aventura ao estilo “hack and slash” exclusivo para Playstation 4", false, 450, "https://images-submarino.b2w.io/produtos/01/00/img/1227812/3/1227812329_1GG.jpg", "PS4", 59.90, 4, "Game God Of War Hits", 1);

select * from tb_produtos;
select * from tb_categorias;