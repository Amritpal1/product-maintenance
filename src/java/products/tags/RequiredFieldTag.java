/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products.tags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author juliantais
 */
public class RequiredFieldTag extends TagSupport {

    
    private String field;
    private String color = "red";

    public void setField(String field) {
        this.field = field;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        if (field == null || field.length() == 0) {
            try {
                out.print("<font color=" + color + "> *</font");
            } catch (IOException ex) {
                Logger.getLogger(RequiredFieldTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return SKIP_BODY;
    }
}
