package com.company.employee.tenant;

import jakarta.servlet.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
public class TenantFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            Object orgClaim = jwt.getClaim("organization");
            String orgId = "GLOBAL";

            if (orgClaim instanceof List<?> orgList && !orgList.isEmpty()) {
                orgId = orgList.get(0).toString();
            } else if (orgClaim instanceof String s) {
                orgId = s;
            }

            TenantContext.setTenantId(orgId);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}