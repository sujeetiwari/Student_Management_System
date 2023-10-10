package edu.sms.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


public class JwtFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse res = (HttpServletResponse) response;
		final String authHeader = req.getHeader("authorization");
		
		if("OPTIONS".equals(req.getMethod()))
		{
			res.setStatus(res.SC_OK);
			chain.doFilter(request, response);
		}
		else
		{
			if(authHeader == null || !authHeader.startsWith("Bearer "))
			{
				throw new ServletException("Missing or Invalid Authorization Header!");
			}
			
			final String token = authHeader.substring(7);
			
			try
			{
				final Claims claims = Jwts.parser().setSigningKey("lolipop")
						.parseClaimsJws(token).getBody();
				req.setAttribute("claims", claims);
			}
			catch(SignatureException e)
			{
				throw new ServletException("Invalid token");
			}
			
			chain.doFilter(request, response);
		}
		
	}

}
