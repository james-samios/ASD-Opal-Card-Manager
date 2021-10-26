<%@ page import="group2.asd.uts.edu.au.opal.model.PaymentMethod" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Information</title>
    <link rel="stylesheet" href="CSS/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<%
    PaymentMethod card = (PaymentMethod) session.getAttribute("card");
    Customer customer = (Customer) request.getSession().getAttribute("customer");
%>

<nav>
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Payment Method</label>

    <ul>
        <!--<li><a href="AddProductController">ADD PRODUCT</a></li>-->
        <li><a href="PaymentMethodServlet?card=all">View Payment Methods</a></li>
        <li><a href="userprofile.jsp">BACK</a></li>
    </ul>

</nav>

<div class="container mt-3 py-2">
    <div class="row">
        <div class="col-md-6">
            <div class="wrapper" id="form">
                <h2>Current card Information</h2>
                <p>Card Owner: <%=card.getCardName()%>
                </p>
                <p>Card Number: <%=card.getCardNumber()%>
                </p>
                <p>Card CVC: <%=card.getCardCVC()%>
                </p>
                <p>Card Expiry: <%=card.getExpiryDate()%>
                </p>
                <h2>Update Card Information</h2>
                <form name="PaymentForm" action="PaymentMethodServlet?method=update" method="POST">
                    <h4>Account</h4>
                    <div class="input-group">
                        <div class=input-box>
                            <input type="text" placeholder="First Name" name="name" value="<%=card.getCardName()%>"
                                   required class="name">
                            <input type="hidden" name="customer" required
                                   value="<%=customer.getAccountId().toString()%>">
                            <input type="hidden" name="card_id" required
                                   value="<%=card.getObjectId().toString()%>">
                        </div>
                    </div>


                    <div class="input-group">
                        <div class="input-box">
                            <input type="text" placeholder="Card Number" name="card_number"
                                   value="<%=card.getCardNumber()%>" class="name">
                        </div>
                    </div>
                    <div class="input-group">
                        <div class="input-box">
                            <input type="text" placeholder="Expiry Date" name="cvc" value="<%=card.getCardCVC()%>"
                                   class="name">
                        </div>
                    </div>
                    <div class="input-group">
                        <div class="input-box">
                            <input type="text" placeholder="CVC" name="expiry_date" value="<%=card.getExpiryDate()%>"
                                   class="name">
                        </div>
                    </div>
                    <div class="input-group">
                        <div class="input-box">
                            <button type="reset">Clear</button>
                            <button type="submit">Update</button>
                        </div>
                    </div>

                </form>

            </div>
        </div>
        <div class="col-md-6">


        </div>
    </div>
</div>

</body>
</html>
<%--
<script>
    const form = document.getElementById('form');
    const email = document.getElementById('email');
    const password = document.getElementById('password');
    const password2 = document.getElementById('password2');

    form.addEventListener('submit', e => {
        e.preventDefault();

        checkInputs();
    });

    function checkInputs() {
        // trim to remove the whitespaces
        const emailValue = email.value.trim();
        const passwordValue = password.value.trim();
        const password2Value = password2.value.trim();

        if(emailValue === '') {
            setErrorFor(email, 'Email cannot be blank');
        } else if (!isEmail(emailValue)) {
            setErrorFor(email, 'Not a valid email');
        } else {
            setSuccessFor(email);
        }

        if(passwordValue === '') {
            setErrorFor(password, 'Password cannot be blank');
        } else {
            setSuccessFor(password);
        }

        if(password2Value === '') {
            setErrorFor(password2, 'Password2 cannot be blank');
        } else if(passwordValue !== password2Value) {
            setErrorFor(password2, 'Passwords does not match');
        } else{
            setSuccessFor(password2);
        }
    }

    function setErrorFor(input, message) {
        const formControl = input.parentElement;
        const small = formControl.querySelector('small');
        formControl.className = 'form-control error';
        small.innerText = message;
    }

    function setSuccessFor(input) {
        const formControl = input.parentElement;
        formControl.className = 'form-control success';
    }

    function isEmail(email) {
        return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
    }
    if (document.querySelectorAll('.form-control')[0].classList.contains('success') && document.querySelectorAll('.form-control')[1].classList.contains('success') && document.querySelectorAll('.form-control')[2].classList.contains('success') && document.querySelectorAll('.form-control')[3].classList.contains('success')) {
        form.submit()
    }
   form.submit()

</script>
--%>

