import "../../css/Login.css"

function Register(){
    return(
        <main class="contenedor-auth">
            <h2>Crea una cuenta</h2>
                <form>
                    <div class="mb-3">
                        <label className="form-label">Nombre</label>
                        <input className="form-control" label="Nombre" name="User_Nombre"/>
                    </div>
                    <div class="mb-3">
                        <label className="form-label">Apellido</label>
                        <input className="form-control" label="Apellido" name="User_Apellido"/>
                    </div>
                    <div class="mb-3">
                        <label className="form-label">DNI</label>
                        <input className="form-control" label="DNI" name="User_DNI"/>
                    </div>
                    <div class="mb-3">
                        <label className="form-label">Correo Electrónico</label>
                        <input className="form-control" label="Email" name="User_Email" type="email"/>
                    </div>
                    <div class="mb-3">
                        <label className="form-label">Telefono</label>
                        <input className="form-control" label="Teléfono" name="User_Telefono"/>
                    </div>
                    <div class="mb-3">
                        <label className="form-label">Dirección</label>
                        <input className="form-control" label="Dirección" name="User_Direccion"/>
                    </div>
                    <div class="mb-3">
                        <label className="form-label">Contraseña</label>
                        <input className="form-control" label="Contraseña" name="User_Password" type="password"/>
                    </div>

                    <button type="submit" class="btn btn-verde">Registrarse</button>
                    <button type="reset" class="btn btn-rojo mt-3">Borrar Campos</button>
                </form>
        </main>
    )
}

export default Register