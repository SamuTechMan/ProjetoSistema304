package br.com.sistema304.BEAN;

public class ContatosUsuariosBeans {
    
private int idusuarios ; 
private String usuario ; 
private String login ; 
private String senha ; 
private String perfil ;
private String email ;

    /**
     * @return the idusuarios
     */
    public int getIdusuarios() {
        return idusuarios;
    }

    /**
     * @param idusuarios the idusuarios to set
     */
    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


}
