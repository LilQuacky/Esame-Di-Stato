class DoPostLoginSignUp extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        
        String Email=request.getParameter("email");
        String Password=request.getParameter("password");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ospedale","root","password");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from utenteweb where email='"+Email+"' and password='"+Password+"'");
            
            if(rs.next()) {
                out.print("Login effettuato");
            }else {
            out.print("L'username e/o la password sono errati, riprova");
            }
            
        }catch(Exception e) {
            out.print("Errore nella fase di registrazione");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String Username=request.getParameter("username");
		String Email=request.getParameter("email");
		String Password=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ospedale","root","password");
			Statement st=conn.createStatement();
			
	 		st.executeUpdate("Insert into utenteweb  value ( '"+Username+"' ,'"+Email+"'.'"+Password+"')");
			out.print("Registrazione effettuata");
			
		}catch(Exception e) {
			out.print("Errore nella fase di registrazione");
		}
	

    }
}



