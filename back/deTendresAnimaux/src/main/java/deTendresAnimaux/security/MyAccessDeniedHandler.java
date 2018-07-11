package deTendresAnimaux.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

	public MyAccessDeniedHandler() {
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		// do some business logic, then redirect to errorPage url

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		// ou redirect to an error page url

	}

}
