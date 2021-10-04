<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Information</title>
    <link rel="stylesheet" href="CSS/payment.css">
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

  <div class="wrapper">
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
                      <input type="text" placeholder="Email" name="paypal_email" class="name">
                  </div>
              </div>

                  <div class="input-group">
                      <div class="input-box">
                          <input type="password" placeholder="Password" name="password" class="name">
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


