import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Томат on 04.06.2017.
 */
public class Filter001 implements Filter {
    static  volatile
    String atributeName;
    String atributeValue;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter");
        System.out.println(servletRequest.getRemotePort());
        Enumeration<String> atributes= servletRequest.getParameterNames();
        while (atributes.hasMoreElements()) {
           atributeName= (String) atributes.nextElement();
           atributeValue= (String) servletRequest.getParameter(atributeName);
            System.out.println(atributeName+ ":  " + atributeValue);
        }
        chain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
