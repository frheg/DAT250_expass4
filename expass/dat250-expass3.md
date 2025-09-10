# Single Web Application

*Students*: Kamil, Maren, Fredric

*Course*: DAT250 at HVL Bergen - Master Software Engineering

*Code*: [https://github.com/Maren24/DAT250](https://github.com/Maren24/DAT250)

## Setup environment

Create two files in the frontend-folder:
[.env.production](../frontend/.env.production)
[.env](../frontend/.env)

Write into this files:
```bash
# .env
VITE_API_BASE_URL=http://localhost:8080
```

and in the other:
```bash
# .env.production
VITE_API_BASE_URL=""
```

## Technical Challenges

- Setup environment file: Different from ReactJS approach with "REACT_APP_" naming in Vite. Short part of refactoring
- ...