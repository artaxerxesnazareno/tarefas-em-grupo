INSERT INTO tb_user(username, email, password) VALUES ('Artaxerxes','artaxerxes@gmail.com', '123456');
INSERT INTO tb_user(username, email, password) VALUES ('Nazare','nazare@gmail.com', '123456');
INSERT INTO tb_user(username, email, password) VALUES ('Maria','maria@gmail.com', '123456');


INSERT INTO tb_project(name, user_id) VALUES ('Umbrella',1);


INSERT INTO tb_task(name, descricao, project_id) VALUES ('primeiros passos','iniciar as configurações e esterilizar a sala',1);
INSERT INTO tb_task(name, descricao, project_id) VALUES ('Definir as prioridades','reunir a equipe e juntos definir as prioridades',1);


--INSERT INTO tb_user_task(task_id, user_id) VALUES (1,2);
