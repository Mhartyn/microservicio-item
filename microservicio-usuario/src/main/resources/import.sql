insert into usuarios (username, password, enabled, nombre, apellido, email) values('mhartyn', '12345', 1, 'martin', 'gutierrez', 'martin@correo.com')
insert into usuarios (username, password, enabled, nombre, apellido, email) values('admin', '12345', 1, 'administrador', 'sistema', 'admin@sistema.com')

insert into roles(nombre) values('ROL_USER')
insert into roles(nombre) values('ROL_ADMIN')

insert into usuarios_roles(usuario_id, rol_id) values(1, 1)
insert into usuarios_roles(usuario_id, rol_id) values(2, 2)
insert into usuarios_roles(usuario_id, rol_id) values(2, 1)