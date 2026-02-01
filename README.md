# employee-service
The Employee Service is a Spring Boot-based OAuth2 Resource Server that manages employee records. It is designed with a Multi-Tenant architecture, ensuring that data is strictly isolated based on the user's organization context provided by Keycloak.


# 🛠 Tech Stack
Java 21

Spring Boot 3.4.1

Spring Security & OAuth2 Resource Server

Spring Data JPA / Hibernate

# 🔑 Security & Multi-Tenancy
This service does not have its own login page. Instead, it validates JWT Access Tokens issued by Keycloak.

1. Token Validation
   The service checks the issuer-uri to ensure the token is authentic. It specifically looks for the organization claim in the JWT.

2. Tenant Extraction
   The TenantFilter intercepts every incoming request to:

Extract the organization claim (handling both String and Array formats).

Store the Organization ID in a ThreadLocal TenantContext.

3. Data Isolation
   All database queries are scoped to the current tenant. For example:

SQL

SELECT * FROM employees WHERE org_id = 'acme';

This prevents a user from "Acme" from ever seeing data belonging to "Globex," even if they know the employee's ID.