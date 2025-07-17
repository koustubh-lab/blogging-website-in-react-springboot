# 📝 Logsy - Your Personal Blogging Platform

**Logsy** is a clean, fast, and secure blogging platform built for creators who want simplicity with power. With passwordless login and rich features, Logsy makes blogging seamless.

---

## 🚀 Features

- 🔐 **Passwordless Authentication** via Magic Link (Resend API)
- 🧑‍💻 **JWT-based Session Management**
- ✍️ **Create, Edit, and Delete Blog Posts**
- 🔍 **Full-Text Search**
- 🏷️ **Tags & Categories**
- 📱 **Responsive UI with Dark Mode**
- 🧾 **SEO-Friendly Blog Posts**
- 🖼️ **Rich Markdown Editor with Live Preview**

---

## 🛠️ Tech Stack

- **Frontend**: ReactJS, TailwindCSS, Shadcn UI
- **Backend**: Java Spring Boot
- **Database**: MySQL
- **Authentication**: Passwordless login (Resend API), JWT for sessions
- **Deployment**: Vercel / Netlify (Frontend), Railway / Render (Backend)

---

## 📸 Screenshots

> *(Include GIFs or images of the homepage, login, and blog editor here.)*

---

## 🚧 Installation

```bash
# Clone the repository
git clone https://github.com/your-username/logsy.git
cd logsy

# Frontend Setup
cd client
npm install
npm run dev

# Backend Setup
cd ../server
./mvnw spring-boot:run
```

> ⚙️ Make sure to configure environment variables (e.g., in `application.properties`) for:
```
spring.datasource.url=jdbc:mysql://localhost:3306/logsy_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
jwt.secret=your_jwt_secret
resend.api.key=your_resend_api_key
frontend.url=http://localhost:5173
```

---

## 📁 Folder Structure

```
logsy/
├── client/        # React frontend
└── server/        # Spring Boot backend
```

---

## 💡 Contributing

Pull requests are welcome! Open an issue to suggest new features or improvements.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙋‍♂️ Author

Built with 💖 by [Your Name](https://github.com/your-username)
