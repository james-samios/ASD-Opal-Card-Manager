<%--
  Created by IntelliJ IDEA.
  User: chrom
  Date: 7/09/2021
  Time: 4:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enquiry Details</title>
    <link rel="stylesheet" href="css/interface.css">
</head>
<body>

    <div class="navbar">
        <a href="#home">Home</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="#contact">Theft or loss</a>
        <a href="#about">Logout</a>
    </div>

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="return">
        <a href="enquiryList.jsp">&lt Return</a>
    </div>

    <div class="enquiryDetails">
        <h1>Enquiry Details</h1>
        <p>This enquiry is currently <span style="color: darkorange">in progress</span>. Our team is reviewing your enquiry and will be in touch with you soon.</p>
        <table class="detailsTable">
            <tr>
                <th>Title:</th>
                <td>How to add funds</td>
            </tr>
            <tr>
                <th>Details:</th>
                <td>Hi, I'm having difficulty adding funds to my card. How do I add funds? Thanks</td>
            </tr>
            <tr>
                <th>Comments:</th>
                <td>Status updated to in progress: we are currently looking into your issue</td>
            </tr>
        </table>

        <div class="addComments">
            <h2>Add Comments</h2>
            <p>You can provide comments to your enquiry if you have further details.</p>
            <form>
                <textarea name="enquiryComments" rows="5" col="50"></textarea>
                <div style="padding: 10px;">
                    <input type="submit" value="Add comment" class="submitButton">
                </div>
            </form>
        </div>

    </div>

</body>
</html>
