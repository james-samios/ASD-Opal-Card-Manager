<%@ page import="group2.asd.uts.edu.au.opal.model.PaymentMethod" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Trip" %>
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
    Trip trip = (Trip) session.getAttribute("trip");
    Customer customer = (Customer) request.getSession().getAttribute("customer");
%>

<nav>
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Edit Trip</label>

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
                <h2>Current Trip Information</h2>
                <p>Trip Start: <%=trip.getTripStart()%>
                </p>
                <p>StartTime: <%=trip.getStartTime().toString()%>
                </p>
                <p>Destination: <%=trip.getTripEnd()%>
                </p>
                <p>End Time: <%=trip.getEndTime().toString()%>
                </p>
                <h2>Update Trip Information</h2>
                <form name="TripForm" action="TripServlet?method=update" method="POST">
                    <div class="input-group">
                        <div class=input-box>
                            <label>Location</label>
                            <input type="text" placeholder="Location" name="location" value="<%=trip.getTripStart()%>"
                                   required class="name">
                            <input type="hidden" name="trip_id" required
                                   value="<%=trip.getObjectId().toString()%>">
                            <input type="hidden" name="fare" required
                                   value="<%=trip.getFare().toString()%>">
                        </div>
                    </div>

                    <div class="input-group">
                        <label>Destination</label>
                        <div class=input-box>
                            <input type="text" placeholder="Destination" name="destination" value="<%=trip.getTripEnd()%>"
                                   required class="name">
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

