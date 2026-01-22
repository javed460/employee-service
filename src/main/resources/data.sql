-- Create Employees for ACME (Alice and others)
INSERT INTO employees (org_id, first_name, last_name, email, position)
VALUES ('acme', 'Alice', 'Smith', 'alice@acme.com', 'Senior Engineer');

INSERT INTO employees (org_id, first_name, last_name, email, position)
VALUES ('acme', 'Bob', 'Jones', 'bob@acme.com', 'HR Manager');

-- Create Employees for GLOBEX (Charlie)
INSERT INTO employees (org_id, first_name, last_name, email, position)
VALUES ('globex', 'Charlie', 'Brown', 'charlie@globex.com', 'Scientist');