import "../../css/Login.css"

function Login(){
    return(
        <main class="contenedor-auth">
            <h2>Inicia Sesión</h2>
                <form>
                    <div className="mb-3">
                        <label className="form-label">Correo Electrónico</label>
                        <input className="form-control" label="Email" name="User_Email"/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Contraseña</label>
                        <input className="form-control" label="Password" type="password" name="User_Password"/>
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" name="mantener" class="form-check-input" id="exampleCheck1"/>
                        <label class="form-check-label" for="exampleCheck1">Mantener sesión iniciada</label>
                    </div>
                    <button type="submit" class="btn btn-rojo">Entrar</button>
                </form>
        </main>
    )
}

export default Login
