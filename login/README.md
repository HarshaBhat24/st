# Login Form with Validation

A pure HTML/CSS/JavaScript login form with client-side validation and attempt limiting.

## 📋 Overview

This project demonstrates:
- HTML5 form structure
- CSS styling with flexbox
- JavaScript form validation
- Client-side security patterns (attempt limiting)
- DOM manipulation

## 🏗️ Project Structure

```
login/
├── README.md       # This file
├── index.html      # Main login page
├── login.js        # Form validation logic
├── style.css       # Styling
└── success.html    # Success page after login
```

## 🚀 Features

### Security Features
- **Attempt Limiting**: Maximum 3 login attempts
- **Input Validation**: Required field validation
- **Account Lockout**: Disables form after failed attempts
- **Client-side Protection**: Basic brute-force prevention

### User Experience
- Clean, modern UI design
- Responsive layout
- Visual feedback on interactions
- Helpful error messages
- Success page redirect

## 💻 How to Use

### Method 1: Direct Browser Open
```bash
cd login
# Open in default browser
xdg-open index.html

# Or open in specific browser
firefox index.html
google-chrome index.html
```

### Method 2: Local Web Server
```bash
# Using Python
cd login
python3 -m http.server 8000

# Access at: http://localhost:8000
```

### Test Credentials
- **Username**: `Form`
- **Password**: `123`

## 📝 File Details

### index.html
Main login page structure with:
- Semantic HTML5
- Form with input fields
- Script and style references
- Demo credentials note

### login.js
Validation logic including:
- Form submit event handling
- Credential verification
- Attempt counter
- Form lockout mechanism
- Success page navigation

### style.css
Modern styling with:
- Flexbox centering
- Card-based layout
- Hover effects
- Responsive design
- Custom button styling

### success.html
Simple success page confirming login

## 🎨 Customization

### Change Credentials
Edit `login.js`:
```javascript
if (username === "YourUsername" && password === "YourPassword") {
    // Login successful
}
```

### Modify Attempt Limit
Edit `login.js`:
```javascript
let attempts = 5; // Change from 3 to 5 attempts
```

### Update Styles
Edit `style.css` to change:
- Colors: `.container { background: #your-color; }`
- Fonts: `body { font-family: 'Your Font', sans-serif; }`
- Layout: Adjust padding, margins, border-radius

## 🎯 Learning Objectives

1. HTML form structure and attributes
2. CSS flexbox for centering
3. JavaScript event handling
4. DOM manipulation methods
5. Client-side form validation
6. User experience patterns
7. Security considerations

## 🔒 Security Notes

⚠️ **Important**: This is a client-side only implementation for learning purposes.

**Not suitable for production because:**
- Credentials are hardcoded in JavaScript (visible in source)
- No server-side validation
- No encryption/hashing
- Easily bypassed by disabling JavaScript
- No session management

**For production, implement:**
- Server-side validation
- Password hashing (bcrypt, Argon2)
- HTTPS/SSL
- CSRF protection
- Rate limiting on server
- Secure session management
- Database-stored credentials

## 🎨 Enhancement Ideas

1. **Password Strength Meter**: Visual indicator of password strength
2. **Remember Me**: Checkbox with localStorage
3. **Show/Hide Password**: Toggle password visibility
4. **Forgot Password**: Password reset flow
5. **Captcha Integration**: reCAPTCHA after failed attempts
6. **Two-Factor Authentication**: SMS or authenticator app
7. **Social Login**: OAuth integration
8. **Accessibility**: ARIA labels and keyboard navigation

## 📱 Browser Compatibility

Tested and works on:
- ✅ Chrome/Edge 90+
- ✅ Firefox 88+
- ✅ Safari 14+
- ✅ Opera 76+

## 📚 Resources

- [MDN Web Forms Guide](https://developer.mozilla.org/en-US/docs/Learn/Forms)
- [OWASP Authentication Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Authentication_Cheat_Sheet.html)
- [CSS Flexbox Guide](https://css-tricks.com/snippets/css/a-guide-to-flexbox/)
