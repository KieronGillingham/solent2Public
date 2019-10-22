<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="org.solent.com504.factoryandfacade.impl.web.WebObjectFactory"%>
<%@page import="org.solent.com504.factoryandfacade.model.dto.Animal"%>
<%@page import="org.solent.com504.factoryandfacade.model.service.FarmFacade"%>
<!--
<%@page import="org.solent.com504.factoryandfacade.model.service.ServiceObjectFactory"%>
<%@page import="org.solent.com504.factoryandfacade.impl.service.ServiceObjectFactoryImpl"%>
-->

<%

    FarmFacade farmFacade = (FarmFacade) WebObjectFactory.getServiceFacade();
    
    /*FarmFacade farmFacade = (FarmFacade) session.getAttribute("farmFacade");

    // synchronised block to prevent multiple creations of factory
    if (farmFacade == null) {
        synchronized (this) {
            if (farmFacade == null) {
                ServiceObjectFactory farmobjectFactory = new ServiceObjectFactoryImpl();
                farmFacade = farmobjectFactory.createFarmFacade();
                session.setAttribute("farmFacade", farmFacade);

                List<String> supportedAnimalTypes = farmobjectFactory.getSupportedAnimalTypes();
                session.setAttribute("supportedAnimalTypes", supportedAnimalTypes);
            }
        }
    }
    */
    
    List<String> supportedAnimalTypes = farmFacade.getSupportedAnimalTypes();

    String animalTypeStr = request.getParameter("animal_type");
    String animalNameStr = request.getParameter("animal_name");
    
    if (animalTypeStr != null || animalNameStr != null)
    {
        farmFacade.addAnimal(animalTypeStr, animalNameStr);
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Farm</title>
    </head>
    <body>
        <h1>Page for Farm v221019.1</h1>
            <%
                //Hard-coded animal instances
                //farmFacade.addAnimal("Cat", "Susan");
                //farmFacade.addAnimal("Dog", "Peter");
                //farmFacade.addAnimal("Cow", "Dave");
            %>
        <form>
            <label> Animal name: </label>
            <input name="animal_name" type="text">
        
            <select name="animal_type">
            <% for (String animalType : supportedAnimalTypes) {%>
                <option><%=animalType%></option>
            <%}  %>
            </select>
            <button type="submit">Add</button>
        </form>
        <h2>Animals on Farm</h2>
        <table>
            <tr>
                <th>Type</th>
                <th>Name</th>
                <th>Sound</th>
            </tr>
            <% for (Animal animal : farmFacade.getAllAnimals()) {%>
            <tr>
                <td><%=animal.getName()%></td>
                <td><%=animal.getAnimalType().getSound() %></td>
                <td><%=animal.getAnimalType().getType() %></td>
            </tr>
            <%
                }
            %>
        </table> 

    </body>
</html>
