insert into usuarios (username, password, enabled, nombre, apellido, email) values('mhartyn', '$2a$10$0Yc.mMT97icF6TDhxtcV1.tjz48kOENkTQdI/2n2cQN89qhstJQiy', true, 'martin', 'gutierrez', 'martin@correo.com')
insert into usuarios (username, password, enabled, nombre, apellido, email) values('admin', '$2a$10$ww2XvzVhqZC5Y074ZCw7ceGXlcwithj4XuNEltgga0vgCkSQnYx/u', true, 'administrador', 'sistema', 'admin@sistema.com')

insert into roles(nombre) values('ROLE_USER')
insert into roles(nombre) values('ROLE_ADMIN')

insert into usuarios_roles(usuario_id, rol_id) values(1, 1)
insert into usuarios_roles(usuario_id, rol_id) values(2, 2)
insert into usuarios_roles(usuario_id, rol_id) values(2, 1)