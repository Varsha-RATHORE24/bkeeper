package com.info.company.config;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.info.company.exception.InvalidHeaderFileException;
import com.info.company.feign.CompanyFeign;
import com.info.company.response.BaseResponse;
import com.info.company.response.ValidationResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class RequestInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private CompanyFeign companyFeign;

    @Autowired
    private JWTUtil jwtUtil;

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(new CustomInterceptor(companyFeign,jwtUtil)).addPathPatterns("/**")
				.excludePathPatterns("/signup");
	}

	private static class CustomInterceptor implements HandlerInterceptor {
		@Value("${jwt.signing.key}")
		public String SIGNING_KEY;

		
		@Value("${jwt.authorities.key}")
		public String AUTHORITIES_KEY;
		private final CompanyFeign companyFeign;
        private final JWTUtil jwtUtil;

		public CustomInterceptor(CompanyFeign companyFeign,JWTUtil jwtUtil) {
			this.companyFeign = companyFeign;
            this.jwtUtil = jwtUtil;
		}

		@Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            System.out.println("Pre-handle logic");
            System.out.println(request);
            String authorizationHeader = request.getHeader("Authorization");
            String token = authorizationHeader.substring(7); // Remove the "Bearer " prefix

            // System.out.println(token);

            ValidationResponse responseData= companyFeign.validate(token); // Example usage of CompanyFeign
            System.out.println(responseData);
            if (responseData.isValid()) {
                String roles = jwtUtil.getClaimFromToken(token);

                if (hasAccess(roles, request.getRequestURI())) {
                    return true;
                } else {
//                	return BaseResponse.builder().code(HttpStatus.SC_UNAUTHORIZED).build();
                    throw new InvalidHeaderFileException("Access denied: insufficient permissions");
                }
            }

            throw new InvalidHeaderFileException("Invalid Request");

        }
		private boolean hasAccess(String userRoles, String path) {
			List<String> requiredRoles = RoleConfig.getRequiredRoles(path);
			return requiredRoles.stream().anyMatch(role->role.equals(userRoles));
		}

//		private UsernamePasswordAuthenticationToken getAuthenticationToken(final String token,
//				final UserDetails userDetails) {
//			final JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);
//			final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
//			final Claims claims = claimsJws.getBody();
//
//			final Collection<? extends GrantedAuthority> authorities = Arrays
//					.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new)
//					.collect(Collectors.toList());
//
//			return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
//		}

//		private DecodedJWT decodeToken(String token) {
//			return JWT.decode(token);
//		}
//
		

	}
}
