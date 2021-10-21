<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Information</title>
    <link rel="stylesheet" href="CSS/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.min.css" rel="stylesheet"
          type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Payment Method</label>

    <ul>
        <!--<li><a href="AddProductController">ADD PRODUCT</a></li>-->
        <li><a href="userprofile.jsp">BACK</a></li>
    </ul>

</nav>

  <div class="wrapper" id="form">
      <h2>Payment Information</h2>
      <form name="PaymentForm" action="paymentRes.jsp" method="post">
          <h4>Account</h4>
          <div class="input-group">
              <div class = input-box>
                 <input type="text" placeholder="First Name" name="first" required class="name">
              </div>
              <div class="input-box">
                  <input type="text" placeholder="Last Name" name="last" required class="name">
              </div>
          </div>

          <div class="input-group">
              <div class="input-box">
                  <input type="text" placeholder="DD/MM/YYYY" name="dob" required class="dob">
              </div>
          </div>

          <div class="input-group">
              <div class="input-box">
                  <h4>Payment Details</h4>
                  <input type="radio" name="pay" id="bc1" checked class="radio">
                  <label for="bc1">Credit Card</label>
              </div>
          </div>
          <div class="input-group">
              <div class="input-box">
                  <input type="text" placeholder="Card Number" name="card_number" class="name">
              </div>
          </div>
          <div class="input-group">
              <div class="input-box">
                  <input type="text" placeholder="Expiry Date" name="cvc" class="name">
              </div>
          </div>
          <div class="input-group">
              <div class="input-box">
                  <input type="text" placeholder="CVC" name="expiry_date" class="name">
              </div>
          </div>

          <div class="input-group">
              <div class="input-box">
                  <input type="radio" name="pay" id="bc2" checked class="radio">
                  <label for="bc2">Paypal</label>
              </div>
          </div>
              <div class="input-group">
                  <div class="input-box">
                      <div class="form-control">
                          <input type="email" placeholder="Email" name="paypal_email" class="name" id="email">
                          <i class="fas fa-check-circle"></i>
                          <i class="fas fa-exclamation-circle"></i>
                          <small>Error Message</small>
                      </div>

                  </div>
              </div>

                  <div class="input-group">
                      <div class="input-box">
                          <div class="form-control">
                          <input type="password" placeholder="Password" name="password" class="name" id="password">
                          <i class="fas fa-check-circle"></i>
                          <i class="fas fa-exclamation-circle"></i>
                          <small>Error Message</small>
                          </div>
                      </div>
                  </div>

          <div class="input-group">
              <div class="input-box">
                  <div class="form-control">
                  <input type="password" placeholder="Confirm Password" name="passwordConfirm" class="name" id="password2">
                  <i class="fas fa-check-circle"></i>
                  <i class="fas fa-exclamation-circle"></i>
                  <small>Error Message</small>
              </div>
              </div>
          </div>

          <div class="input-group">
              <div class="input-box">
                  <button type="reset">Clear</button>
                  <button type="submit">Submit</button>


              </div>
          </div>

     </form>
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

