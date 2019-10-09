<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="org.solent.com504.factoryandfacade.model.Animal"%>
<%@page import="org.solent.com504.factoryandfacade.model.FarmFacade"%>
<%@page import="org.solent.com504.factoryandfacade.model.FarmObjectFactory"%>
<%@page import="org.solent.com504.factoryandfacade.impl.FarmObjectFactoryImpl"%>

<%

    FarmFacade farmFacade = (FarmFacade) session.getAttribute("farmFacade");

    // synchronised block to prevent multiple creations of factory
    if (farmFacade == null) {
        synchronized (this) {
            if (farmFacade == null) {
                FarmObjectFactory farmobjectFactory = new FarmObjectFactoryImpl();
                farmFacade = farmobjectFactory.createFarmFacade();
                session.setAttribute("farmFacade", farmFacade);

                List<String> supportedAnimalTypes = farmobjectFactory.getSupportedAnimalTypes();
                session.setAttribute("supportedAnimalTypes", supportedAnimalTypes);
            }
        }
    }

    List<String> supportedAnimalTypes = (List<String>) session.getAttribute("supportedAnimalTypes");

    String animalTypeStr = request.getParameter("animalType");
    String animalNameStr = request.getParameter("animalName");
    
    if (animalTypeStr != null || animalNameStr != null)
    {}
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Farm</title>
    </head>
    <body>
        <p>Page for Farm</p>
        <p>Supported Animal Types</p>
        <table>
            <% for (String animalType : supportedAnimalTypes) {%>
            <tr>
                <td><%=animalType%></td>
            </tr>
            <%
                }
                //Hard-coded animal instances
                //farmFacade.addAnimal("Cat", "Susan");
                //farmFacade.addAnimal("Dog", "Peter");
                //farmFacade.addAnimal("Cow", "Dave");
            %>
        </table> 
        
        <input type="text">
        
        <select name="dropdown_AnimalType">
        <% for (String animalType : supportedAnimalTypes) {%>
            <option><%=animalType%></option>
        <%}  %>
        </select>
        <button onClick="">Add</button>
        <h2>Animals on Farm</h2>
        <table>
            <tr>
                <th>Type</th>
                <th>Name</th>
                <th>Sound</th>
            </tr>
            <% for (Animal animal : farmFacade.getAllAnimals()) {%>
            <tr>
                <td><%=animal.getAnimalType()%></td>
                <td><%=animal.getName()%></td>
                <td><%=animal.getSound()%></td>
            </tr>
            <%
                }
            %>
        </table> 

    </body>
</html>
