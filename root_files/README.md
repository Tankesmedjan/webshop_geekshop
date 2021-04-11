## Docker compose project

**Will create a project containing 3 images: mysql 5.7, geeksqueek_app-server and geeksqueek_app-client.**

1. Create project folder structure as demonstrated below

2. Pull Github repository for backend from:
   https://github.com/Tankesmedjan/webshop_geekshop.git, save it to folder `backend` under `root`.
   Move demo-dump.sql and docker-compose.yml from `root_files` to `root`

3. Pull Github repository for frontend from:
   https://github.com/Tankesmedjan/webshop_geekshop_frontend.git, save it to folder `frontend` under `root`

4. Build Docker container with Terminal from `root`: docker-compose -p geeksqueek up
   
5. Browse to http://localhost:3000 to view the web shop. (Backend will run on port 3001)


```
<root>
├── demo-dump.sql (from backend git)
├── docker-compose.yml (from backend git)
│
├── <backend> (from git)
│   └── dockerfile
│   └── ...
│
├── <frontend> (from git)
│   └── dockerfile
│   └── nginx.conf
│   └── ...
```