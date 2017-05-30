package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

 @WebListener
public class SessionsCountListener implements ServletContextListener,
		HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer count = (Integer) ctx.getAttribute("count");
		ctx.setAttribute("count", count + 1);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer count = (Integer) ctx.getAttribute("count");
		ctx.setAttribute("count", count - 1);

	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("count", 0);
	}

}
