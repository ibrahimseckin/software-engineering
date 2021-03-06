package getServices.controller;


import getServices.dao.CommentDao;

import getServices.dao.MyfieldsDao;

import getServices.dao.ProviderDao;
import getServices.model.Comments;
import getServices.model.Provider;
import getServices.model.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "detailsProvider")
@ViewScoped

/**
 *
 * @author yiğido
 */
public class ProviderDetailsController {
    
    private Provider provider = new Provider();
//    private List<Field> fieldList;
    private final ProviderDao providerdao;
    private final MyfieldsDao myfieldsdao;
    private int passedParameter;
    private  List<Comments> commentList = new ArrayList<Comments>();
    private String message;
    private List<String> fieldListe;

    
    public ProviderDetailsController() throws Exception{
        providerdao = new ProviderDao();
        myfieldsdao = new MyfieldsDao();
        this.passedParameter = getPassedParameter();
        provider = providerdao.getOneProvider(getPassedParameter());

        commentList = GetProviderCommentList(passedParameter);

        fieldListe=myfieldsdao.getFields(passedParameter);
    }
    
    
    public final int getPassedParameter() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.passedParameter = Integer.parseInt(facesContext.getExternalContext().
                getRequestParameterMap().get("id"));
        return this.passedParameter;
    }
    
    public void setPassedParameter(int passedParameter) {
        this.passedParameter = passedParameter;
    }
    
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * @return the fieldListe
     */
    public List<String> getFieldListe() {
        return fieldListe;
    }

    /**
     * @param fieldListe the fieldListe to set
     */
    public void setFieldListe(List<String> fieldListe) {
        this.fieldListe = fieldListe;
    }
    
    public String SendMessage(String message) throws Exception
    {
        CommentDao cDao = new CommentDao();
        //
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Session session = (Session) sessionMap.get("session");
        if(!session.isIsLoggedIn()) return "index.jsf?faces-redirect=true";
        int id = session.getUserId();
        cDao.insertComment(id, this.passedParameter, message);
        return "providerDetails.jsf?faces-redirect=true&id="+passedParameter;
    }
        
    public List<Comments> GetProviderCommentList(int providerid) throws Exception 
    {
        List<Comments> pcomments = new ArrayList<Comments>();
        CommentDao cDao = new CommentDao();
        pcomments = cDao.getProviderComments(providerid);
        return pcomments;
    }

    /**
     * @return the commentList
     */
    public List<Comments> getCommentList() {
        return commentList;
    }

    /**
     * @param commentList the commentList to set
     */
    public void setCommentList(List<Comments> commentList) {
        this.commentList = commentList;
    }
    
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
