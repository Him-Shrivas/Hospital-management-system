import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Color.*;
class Doctor implements ActionListener
{
	JFrame f;
	JPanel dp1;
	JLabel dl1,dl2,dl3,dl4,dl5,dl6,dl7,dl8,dl9,dl10;
	JTextField dt1,dt2,dt3,dt4,dt5,dt6,dt7,dt8;
	Choice dc1,dc2;
	JButton db1,db2,db3,db4;
	String ds1,ds2,ds3,ds4,ds5,ds6,ds7,ds8,ds9,ds10;
	Doctor()
	{
		f=new JFrame();
		dp1=new JPanel();
		f.setSize(1600,900);		
		f.setVisible(true);
		f.setLayout(new FlowLayout());
		f.add(dp1);
		f.setTitle("Doctor's Tab");
		f.setBackground(Color.PINK);
		dl1=new JLabel("Doctor ID:");
		dl2=new JLabel("Full Name:");
		dl3=new JLabel("Father's Name:");
		dl4=new JLabel("Email-id:");
		dl5=new JLabel("Contact no.:");
		dl6=new JLabel("Address:");
		dl7=new JLabel("Qualifications:");
		dl8=new JLabel("Gender:");
		dl9=new JLabel("Blood Group:");
		dl10=new JLabel("Date of Joining:");

		dt1=new JTextField(50);
		dt2=new JTextField();
		dt3=new JTextField();
		dt4=new JTextField();
		dt5=new JTextField();
		dt6=new JTextField();
		dt7=new JTextField();
		dt8=new JTextField();

		dc1=new Choice();
		dc1.add("Male");
		dc1.add("Female");
		dc1.add("Other");

		dc2=new Choice();
		dc2.add("A+");
		dc2.add("A-");
		dc2.add("B+");
		dc2.add("B-");
		dc2.add("AB+");
		dc2.add("AB-");
		dc2.add("O+");
		dc2.add("O-");
		
		dp1.add(dl1);
		dp1.add(dt1);

		dp1.add(dl2);
		dp1.add(dt2);

		dp1.add(dl3);
		dp1.add(dt3);

		dp1.add(dl4);
		dp1.add(dt4);

		dp1.add(dl5);
		dp1.add(dt5);

		dp1.add(dl6);
		dp1.add(dt6);

		dp1.add(dl7);
		dp1.add(dt7);

		dp1.add(dl8);
		dp1.add(dc1);

		dp1.add(dl9);
		dp1.add(dc2);

		dp1.add(dl10);
		dp1.add(dt8); 	
 
		db1=new JButton("NEW");
		db2=new JButton("UPDATE");
		db3=new JButton("DELETE");
		db4=new JButton("SEARCH");

		dp1.add(db1);
		dp1.add(db2);
		dp1.add(db3);
		dp1.add(db4);
	
		 
		dp1.setLayout(new GridLayout(12,2));
		db1.addActionListener(this);
		db2.addActionListener(this);
		db3.addActionListener(this);
		db4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a)
	{
		ds1=dt1.getText();
		ds2=dt2.getText();
		ds3=dt3.getText();
		ds4=dt4.getText();
		ds5=dt5.getText();
		ds6=dt6.getText();
		ds7=dt7.getText();
		ds8=dt8.getText();
				
		if(a.getSource()==db1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?)");
				pstmt.setString(1,ds1);
				pstmt.setString(2,ds2);
				pstmt.setString(3,ds3);
				pstmt.setString(4,ds4);
				pstmt.setString(5,ds5);
				pstmt.setString(6,ds6);
				pstmt.setString(7,ds7);
				pstmt.setString(8,ds8);
				
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Inserted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				dt1.setText("");
				dt2.setText("");
				dt3.setText("");
				dt4.setText("");
				dt5.setText("");
				dt6.setText("");
				dt7.setText("");
				dt8.setText(""); 
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==db2)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("update doctor set Full_Name=?,Fathers_Name=?,Emailid=?,Contact_No=?,Address=?,Qualifications=?,Gender=?,Blood_Group=?,Date_of_Joining=? where Doctor_ID=?");
				pstmt.setString(1,ds1);
				pstmt.setString(2,ds2);
				pstmt.setString(3,ds3);
				pstmt.setString(4,ds4);
				pstmt.setString(5,ds5);
				pstmt.setString(6,ds6);
				pstmt.setString(7,ds7);
				pstmt.setString(8,ds8);
	
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Updated succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				dt1.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}	
		}
		if(a.getSource()==db3)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("delete from doctor where Doctor_ID=?");
				pstmt.setString(1,ds1);
				 
	
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Deleted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				dt1.setText("");
 
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==db4)
		{
 			 try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
					PreparedStatement pstmt=con.prepareStatement("select * from  doctor where Doctor_ID=?");
					pstmt.setString(1,ds1);
	 
	
					ResultSet rs=pstmt.executeQuery();
		
					if(!rs.next())
					{
						JOptionPane.showMessageDialog(f,"No Record!!!!");
						dt1.setText("");
					}
					else
					{
					 	 dt1.setText(rs.getString(1));
					 	 dt2.setText(rs.getString(2));
 						 dt3.setText(rs.getString(3));
					 	 dt4.setText(rs.getString(4));
					 	 dt5.setText(rs.getString(5));
					 	 dt6.setText(rs.getString(6));
					 	 dt7.setText(rs.getString(7));
					 	 dt8.setText(rs.getString(8));
					}
					con.close();
	    			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(f,e);
				}
		}
	}
}
class patient implements ActionListener
{
	JFrame f;
	JPanel pp1;
	JLabel pl1,pl2,pl3,pl4,pl5,pl6,pl7,pl8,pl9,pl10;
	JTextField pt1,pt2,pt3,pt4,pt5,pt6,pt7;
	JTextArea pta1;
	Choice pc1,pc2;
	JButton pb1,pb2,pb3,pb4;
	String ps1,ps2,ps3,ps4,ps5,ps6,ps7;
	patient()
	{
		f=new JFrame();
		pp1=new JPanel();
		f.setSize(1600,900);		
		f.setVisible(true);
		f.setTitle("Patient's Tab");
		f.setLayout(new FlowLayout());
 		f.add(pp1);
		pl1=new JLabel("Patient ID:");
		pl2=new JLabel("Full Name:");
		pl3=new JLabel("Father's Name:");
		pl4=new JLabel("Email-id:");
		pl5=new JLabel("Contact no.:");
		pl6=new JLabel("Address:");
		pl7=new JLabel("Age:");
		pl8=new JLabel("Gender:");
		pl9=new JLabel("Blood Group:");
		pl10=new JLabel("Information:");

		pt1=new JTextField(50);
		pt2=new JTextField();
		pt3=new JTextField();
		pt4=new JTextField();
		pt5=new JTextField();
		pt6=new JTextField();
		pt7=new JTextField();
		pta1=new JTextArea();

		pc1=new Choice();
		pc1.add("Male");
		pc1.add("Female");

		pc2=new Choice();
		pc2.add("A+");
		pc2.add("A-");
		pc2.add("B+");
		pc2.add("B-");
		pc2.add("AB+");
		pc2.add("AB-");
		pc2.add("O+");
		pc2.add("O-");
		
		pp1.add(pl1);
		pp1.add(pt1);

		pp1.add(pl2);
		pp1.add(pt2);

		pp1.add(pl3);
		pp1.add(pt3);

		pp1.add(pl4);
		pp1.add(pt4);

		pp1.add(pl5);
		pp1.add(pt5);

		pp1.add(pl6);
		pp1.add(pt6);

		pp1.add(pl7);
		pp1.add(pt7);

		pp1.add(pl8);
		pp1.add(pc1);

		pp1.add(pl9);
		pp1.add(pc2);

		pp1.add(pl10);
		pp1.add(pta1); 	
 

		pb1=new JButton("NEW");
		pb2=new JButton("UPDATE");
		pb3=new JButton("DELETE");
		pb4=new JButton("SEARCH");

		pp1.add(pb1);
		pp1.add(pb2);
		pp1.add(pb3);
		pp1.add(pb4);
	
		 
		pp1.setLayout(new GridLayout(12,2));
		pb1.addActionListener(this);
		pb2.addActionListener(this);
		pb3.addActionListener(this);
		pb4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a)
	{
		ps1=pt1.getText();
		ps2=pt2.getText();
		ps3=pt3.getText();
		ps4=pt4.getText();
		ps5=pt5.getText();
		ps6=pt6.getText();
		ps7=pt7.getText();
		if(a.getSource()==pb1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
				pstmt.setString(1,ps1);
				pstmt.setString(2,ps2);
				pstmt.setString(3,ps3);
				pstmt.setString(4,ps4);
				pstmt.setString(5,ps5);
				pstmt.setString(6,ps6);
				pstmt.setString(7,ps7);
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Inserted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				pt1.setText("");
				pt2.setText("");
				pt3.setText("");
				pt4.setText("");
				pt5.setText("");
				pt6.setText("");
				pt7.setText("");

			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==pb2)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("update patient set Full_Name=?,Father_Name=?,Emailid=?,Contact_No=?,Address=?,Age=? where Patient_ID=?");
				pstmt.setString(1,ps1);
				pstmt.setString(2,ps2);
				pstmt.setString(3,ps3);
				pstmt.setString(4,ps4);
				pstmt.setString(5,ps5);
				pstmt.setString(6,ps6);
				pstmt.setString(7,ps7);
	
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Updated succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				pt1.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}	
		}
		if(a.getSource()==pb3)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("delete from patient where Patient_ID=?");
				pstmt.setString(1,ps1);
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Deleted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				pt1.setText("");
 
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==pb4)
		{
 			 try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("select * from patient where Patient_ID=?");
				pstmt.setString(1,ps1);
	 
	
				ResultSet rs=pstmt.executeQuery();
		
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(f,"No Record!!!!");
					pt1.setText("");
				}
				else
				{
				 	 pt1.setText(rs.getString(1));
				 	 pt2.setText(rs.getString(2));
 					 pt3.setText(rs.getString(3));
				 	 pt4.setText(rs.getString(4));
				 	 pt5.setText(rs.getString(5));
				 	 pt6.setText(rs.getString(6));
				 	 pt7.setText(rs.getString(7));
				}
				con.close();
	   		}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
	}
}
class patientadmit implements ActionListener
{
	JFrame f;
	JPanel pap1;
	JLabel pal1,pal2,pal3,pal4,pal5,pal6,pal7,pal8,pal9,pal10;
	JTextField pat1,pat2,pat3,pat4,pat5,pat6,pat7,pat8;
	JTextArea pata1;
	Choice pac1,pac2;
	JButton pab1,pab2,pab3,pab4;
	String pas1,pas2,pas3,pas4,pas5,pas6,pas7,pas8;
 	patientadmit()
	{
		f=new JFrame();
		f.setSize(1600,900);		
		f.setVisible(true);
		pap1=new JPanel();
		f.setLayout(new FlowLayout());
		f.setTitle("Patient Admit Tab");
		f.add(pap1);
		pal1=new JLabel("Patient ID:");
		pal2=new JLabel("Full Name:");	
		pal3=new JLabel("Gender:");
		pal4=new JLabel("Blood Group:");
		pal5=new JLabel("Disease:");
		pal6=new JLabel("Admit Date:");
		pal7=new JLabel("Room No.:");
		pal8=new JLabel("Doctor ID:");		
		pal9=new JLabel("Doctor Name:");
		pal10=new JLabel("Remarks:");				
	
		pat1=new JTextField(50);
		pat2=new JTextField();
		pat3=new JTextField();
		pat4=new JTextField();
		pat5=new JTextField();	
		pat6=new JTextField();
		pat7=new JTextField();	
		pata1=new JTextArea();	
	
		pac1=new Choice();
		pac1.add("Male");
		pac1.add("Female");
		pac2=new Choice();
		pac2.add("A+");
		pac2.add("A-");
		pac2.add("B+");	
		pac2.add("B-");
		pac2.add("AB+");
		pac2.add("AB-");
		pac2.add("O+");
		pac2.add("O-");
				
		pap1.add(pal1);
		pap1.add(pat1);
	
		pap1.add(pal2);
		pap1.add(pat2);

		pap1.add(pal3);
		pap1.add(pac1);
	
		pap1.add(pal4);
		pap1.add(pac2);
		
		pap1.add(pal5);
		pap1.add(pat3);
	
		pap1.add(pal6);
		pap1.add(pat4);
	
		pap1.add(pal7);
		pap1.add(pat5);

		pap1.add(pal8);
		pap1.add(pat6);
	
		pap1.add(pal9);
		pap1.add(pat7);

		pap1.add(pal10);
		pap1.add(pata1); 	
 

		pab1=new JButton("NEW");
		pab2=new JButton("UPDATE");
		pab3=new JButton("DELETE");
		pab4=new JButton("SEARCH");

		pap1.add(pab1);
		pap1.add(pab2);
		pap1.add(pab3);
		pap1.add(pab4);
	
		 
		pap1.setLayout(new GridLayout(12,2));

		pab1.addActionListener(this);
		pab2.addActionListener(this);
		pab3.addActionListener(this);
		pab4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a)
	{
		pas1=pat1.getText();
		pas2=pat2.getText();
		pas3=pat3.getText();
		pas4=pat4.getText();
		pas5=pat5.getText();
		pas6=pat6.getText();
		pas7=pat7.getText();
 		pas8=pata1.getText();

		if(a.getSource()==pab1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("insert into patientadmit values(?,?,?,?,?,?,?,?)");
				pstmt.setString(1,pas1);
				pstmt.setString(2,pas2);
				pstmt.setString(3,pas3);
				pstmt.setString(4,pas4);
				pstmt.setString(5,pas5);
				pstmt.setString(6,pas6);
				pstmt.setString(7,pas7);
				pstmt.setString(8,pas8);
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Inserted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				pat1.setText("");
				pat2.setText("");
				pat3.setText("");
				pat4.setText("");
				pat5.setText("");
				pat6.setText("");
				pat7.setText("");
				pata1.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==pab2)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("update patientadmit set Full_Name=?,Disease=?,Room_No=?,Doctor_ID=?,Doctor_Name=?,Remarks=?,Admit_Date=?, where Patient_ID=?");
				pstmt.setString(1,pas1);
				pstmt.setString(2,pas2);
				pstmt.setString(3,pas3);
				pstmt.setString(4,pas4);
				pstmt.setString(5,pas5);
				pstmt.setString(6,pas6);
				pstmt.setString(7,pas7);
				pstmt.setString(8,pas8);
	
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Updated succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				pat1.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}	
		}
		if(a.getSource()==pab3)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("delete from patientadmit where Patient_ID=?");
				pstmt.setString(1,pas1);
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Deleted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				pat1.setText("");
 
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==pab4)
		{
 			 try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("select * from patientadmit where Patient_ID=?");
				pstmt.setString(1,pas1);
	 
	
				ResultSet rs=pstmt.executeQuery();
		
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(f,"No Record!!!!");
					pat1.setText("");
				}
				else
				{
				 	 pat1.setText(rs.getString(1));
				 	 pat2.setText(rs.getString(2));
 					 pat3.setText(rs.getString(3));
				 	 pat4.setText(rs.getString(4));
				 	 pat5.setText(rs.getString(5));
				 	 pat6.setText(rs.getString(6));
				 	 pat7.setText(rs.getString(7));
					 pata1.setText(rs.getString(8));
				}
				con.close();
	   		}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
	}
}
class bill implements ActionListener
{
	JFrame f;
	JPanel  bp1;
	JLabel  bl1,bl2,bl3,bl4,bl5,bl6,bl7,bl8,bl9,bl10,bl11,bl12,bl13,bl14,bl15,bl16,bl17,bl18,bl19;
	JTextField  bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17;
	Choice bch1,bch2;
	JButton  bb1,bb2,bb3,bb4;
	String bs1,bs2,bs3,bs4,bs5,bs6,bs7,bs8,bs9,bs10,bs11,bs12,bs13,bs14,bs15,bs16,bs17;
	bill()
	{
		f=new JFrame();
		bp1=new JPanel();
		f.setSize(1600,900);		
		f.setVisible(true);
		f.setTitle("Bill's Tab");
		f.setLayout(new FlowLayout());
		f.add(bp1);
 		bl1=new JLabel("Patient ID:");
		bl2=new JLabel("Patient Name:");
		bl3=new JLabel("Gender:");
		bl4=new JLabel("Blood Group:");
		bl5=new JLabel("Disease:");
		bl6=new JLabel("Admit Date:");
		bl7=new JLabel("Room No.:");
		bl8=new JLabel("Doctor ID:");
		bl9=new JLabel("Doctor Name:");
		bl10=new JLabel("Discharge Date:");
		bl11=new JLabel("Room Charge:");
		bl12=new JLabel("Number of Days:");
		bl13=new JLabel("Total Room Charge:");
		bl14=new JLabel("Service Charge:");
		bl15=new JLabel("Billing Date:");
		bl16=new JLabel("Payment Mode:");
		bl17=new JLabel("Payment Mode Details:");
		bl18=new JLabel("Total Charge:");
		bl19=new JLabel("Bill No.:");
 
		bt1=new JTextField(50);
		bt2=new JTextField(50);
		bt3=new JTextField(50);
		bt4=new JTextField(50);
		bt5=new JTextField(50);
		bt6=new JTextField(50);
		bt7=new JTextField(50);
		bt8=new JTextField(50);
		bt9=new JTextField(50);
		bt10=new JTextField(50);
		bt11=new JTextField(50);
		bt12=new JTextField(50);
		bt13=new JTextField(50);
		bt14=new JTextField(50);
		bt15=new JTextField(50);
		bt16=new JTextField(50);
		bt17=new JTextField(50);

		bch1=new Choice();
		bch1.add("Male");
		bch1.add("Female");

		bch2=new Choice();
		bch2.add("A+");
		bch2.add("A-");
		bch2.add("B+");
		bch2.add("B-");
		bch2.add("AB+");
		bch2.add("AB-");
		bch2.add("O+");
		bch2.add("O-");

		bp1.add(bl1);
		bp1.add(bt1);

		bp1.add(bl2);
		bp1.add(bt2);

		bp1.add(bl3);
		bp1.add(bch1);

		bp1.add(bl4);
		bp1.add(bch2);

		bp1.add(bl5);
		bp1.add(bt3);

		bp1.add(bl6);
		bp1.add(bt4);

		bp1.add(bl7);
		bp1.add(bt5);

		bp1.add(bl8);
		bp1.add(bt6);

		bp1.add(bl9);
		bp1.add(bt7);

		bp1.add(bl10);
		bp1.add(bt8);

		bp1.add(bl11);
		bp1.add(bt9);

		bp1.add(bl12);
		bp1.add(bt10);

		bp1.add(bl13);
		bp1.add(bt11);

		bp1.add(bl14);
		bp1.add(bt12);

		bp1.add(bl15);
		bp1.add(bt13);

		bp1.add(bl16);
		bp1.add(bt14);

		bp1.add(bl17);
		bp1.add(bt15);

		bp1.add(bl18);
		bp1.add(bt16);

		bp1.add(bl19);
		bp1.add(bt17);
		
		bb1=new JButton("NEW");
		bb2=new JButton("UPDATE");
		bb3=new JButton("DELETE");
		bb4=new JButton("SEARCH");
		
		bp1.add(bb1);
		bp1.add(bb2);
		bp1.add(bb3);
		bp1.add(bb4);

		bp1.setLayout(new GridLayout(23,2));

		bb1.addActionListener(this);
		bb2.addActionListener(this);
		bb3.addActionListener(this);	
		bb4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a)
	{
		bs1=bt1.getText();
		bs2=bt2.getText();
		bs3=bt3.getText();
		bs4=bt4.getText();
		bs5=bt5.getText();
		bs6=bt6.getText();
		bs7=bt7.getText();
		bs8=bt8.getText();
		bs9=bt9.getText();
		bs10=bt10.getText();
		bs11=bt11.getText();
		bs12=bt12.getText();
		bs13=bt13.getText();
		bs14=bt14.getText();
		bs15=bt15.getText();
		bs16=bt16.getText();
		bs17=bt17.getText();

		if(a.getSource()==bb1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("insert into bill values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1,bs1);
				pstmt.setString(2,bs2);
				pstmt.setString(3,bs3);
				pstmt.setString(4,bs4);
				pstmt.setString(5,bs5);
				pstmt.setString(6,bs6);
				pstmt.setString(7,bs7);
				pstmt.setString(8,bs8);
				pstmt.setString(9,bs9);
				pstmt.setString(10,bs10);
				pstmt.setString(11,bs11);
				pstmt.setString(12,bs12);
				pstmt.setString(13,bs13);
				pstmt.setString(14,bs14);
				pstmt.setString(15,bs15);
				pstmt.setString(16,bs16);
				pstmt.setString(17,bs17);
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Inserted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				bt1.setText("");
				bt2.setText("");
				bt3.setText("");
				bt4.setText("");
				bt5.setText("");
				bt6.setText("");
				bt7.setText("");
				bt8.setText("");
				bt9.setText("");
				bt10.setText("");
				bt11.setText("");
				bt12.setText("");
				bt13.setText("");
				bt14.setText("");
				bt15.setText("");
				bt16.setText("");
				bt17.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==bb2)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("update bill set Pateint_Name=?,Disease=?,Admit_Date=?,Room_No=?,Doctor_ID=?,Doctor_Name=?,Discharge_Date=?,Room_Charge=?,Number_Of_Days=?,Total_Room_Charge=?,Service_Charge=?,Billing_Date=?,Payment_Mode=?,Payment_Mode_Details=?,Total_Charge=?,Bill_No=? where Patient_ID=?");
			
				pstmt.setString(1,bs1);
				pstmt.setString(2,bs2);
				pstmt.setString(3,bs3);
				pstmt.setString(4,bs4);
				pstmt.setString(5,bs5);
				pstmt.setString(6,bs6);
				pstmt.setString(7,bs7);
				pstmt.setString(8,bs8);
				pstmt.setString(9,bs9);
				pstmt.setString(10,bs10);
				pstmt.setString(11,bs11);
				pstmt.setString(12,bs12);
				pstmt.setString(13,bs13);
				pstmt.setString(14,bs14);
				pstmt.setString(15,bs15);
				pstmt.setString(16,bs16);
				pstmt.setString(17,bs17);
	
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Updated succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				bt1.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}	
		}
		if(a.getSource()==bb3)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("delete from bill where Patient_ID=?");
				pstmt.setString(1,bs1);
				 
	
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Deleted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				bt1.setText("");
 
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==bb4)
		{
 			 try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
					PreparedStatement pstmt=con.prepareStatement("select * from  bill where Patient_ID=?");
					pstmt.setString(1,bs1);
	 
	
					ResultSet rs=pstmt.executeQuery();
		
					if(!rs.next())
					{
						JOptionPane.showMessageDialog(f,"No Record!!!!");
						bt1.setText("");
					}
					else
					{
	 					bt1.setText(rs.getString(1));
 						bt2.setText(rs.getString(2));
						bt3.setText(rs.getString(3));
 						bt4.setText(rs.getString(4));
						bt5.setText(rs.getString(5));
						bt6.setText(rs.getString(6));
						bt7.setText(rs.getString(7));
						bt8.setText(rs.getString(8));
						bt9.setText(rs.getString(9));
						bt10.setText(rs.getString(10));
						bt11.setText(rs.getString(11));
						bt12.setText(rs.getString(12));
						bt13.setText(rs.getString(13));
						bt14.setText(rs.getString(14));
						bt15.setText(rs.getString(15));
						bt16.setText(rs.getString(16));
						bt17.setText(rs.getString(17));
					}
					con.close();
	    			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(f,e);
				}
		}
	}	
}
class service implements ActionListener
{
	JFrame f;
	JPanel sp1 ;
	JLabel  sl1,sl2,sl3,sl4,sl5;
	JTextField st1,st2,st3,st4,st5 ;
	JButton  sb1,sb2,sb3,sb4;
	Choice sc1;
	String ss1,ss2,ss3,ss4,ss5;
	service()
	{
		f=new JFrame();
		sp1=new JPanel();
		f.setSize(1600,900);		
		f.setVisible(true);
		f.setTitle("Services Tab");
		f.setLayout(new FlowLayout());
		f.add(sp1);
		sl1=new JLabel("Service Name:");
		sl2=new JLabel("Service Date:");
		sl3=new JLabel("Patient ID:");
		sl4=new JLabel("Patient Name:");
		sl5=new JLabel("Service Charge:");

		st1=new JTextField();
		st2=new JTextField(50);
		st3=new JTextField();
		st4=new JTextField();
		st5=new JTextField();
 
		sp1.add(sl1);
		sp1.add(st1);

		sp1.add(sl2);
		sp1.add(st2);

		sp1.add(sl3);
		sp1.add(st3);

		sp1.add(sl4);
		sp1.add(st4);

		sp1.add(sl5);
		sp1.add(st5);
		
		sb1=new JButton("NEW");
		sb2=new JButton("UPDATE");
		sb3=new JButton("DELETE");
		sb4=new JButton("SEARCH");
		
		sp1.add(sb1);
		sp1.add(sb2);
		sp1.add(sb3);
		sp1.add(sb4);
		sp1.setLayout(new GridLayout(7,2));
		sb1.addActionListener(this);
		sb2.addActionListener(this);			
		sb3.addActionListener(this);
		sb4.addActionListener(this);
	}
 
	public void actionPerformed(ActionEvent a)
	{
	 	ss1=st1.getText();
		ss2=st2.getText();
		ss3=st3.getText();
		ss4=st4.getText();
		ss5=st5.getText();
		if(a.getSource()==sb1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("insert into  service values(?,?,?,?,?,)");
				pstmt.setString(1,ss1);
				pstmt.setString(2,ss2);
				pstmt.setString(3,ss3);
				pstmt.setString(4,ss4);
				pstmt.setString(5,ss5);
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Inserted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				st1.setText("");
				st2.setText("");
				st3.setText("");
				st4.setText("");
				st5.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==sb2)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("update service set Service_Name=?,Service_Date=?,Patient_Name=?,Service_Charge=? where Patient_ID=?");
				pstmt.setString(1,ss1);
				pstmt.setString(2,ss2);
				pstmt.setString(3,ss3);
				pstmt.setString(4,ss4);
				pstmt.setString(5,ss5);
		
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Updated succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				st3.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}	
		}
		if(a.getSource()==sb3)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("delete from service where Patient_ID=?");
				pstmt.setString(3,ss3);
				int i=pstmt.executeUpdate();
		
				if(i!=0)
				{
					JOptionPane.showMessageDialog(f,"Record Deleted succefully!!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error####");
				}
				con.close();
				st3.setText("");
 
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
		if(a.getSource()==sb4)
		{
 			 try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql","root","root1");
				PreparedStatement pstmt=con.prepareStatement("select * from service where Patient_ID=?");
				pstmt.setString(3,ss3);
	 
	
				ResultSet rs=pstmt.executeQuery();
		
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(f,"No Record!!!!");
					st3.setText("");
				}
				else
				{
				 	 st1.setText(rs.getString(1));
				 	 st2.setText(rs.getString(2));
 					 st3.setText(rs.getString(3));
				 	 st4.setText(rs.getString(4));
				 	 st5.setText(rs.getString(5));
				}
				con.close();
	   		}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(f,e);
			}
		}
	}	
}
class Logintab extends JFrame implements ActionListener
{ 
	JButton b1,b2,b3;
 	JPanel p1;
 	JLabel user,pass;
	final JTextField t1, t2;
	int i;
	Logintab()
	{
		setSize(450,250);
 		setVisible(true);
		setLayout(new FlowLayout());
	
		user = new JLabel("Username:");
		pass = new JLabel("Password:");

		Font font = new Font( "Times New Roman",Font.BOLD,16);
		user.setFont(font);
		pass.setFont(font);
		t1 = new JTextField(15);
		t2 = new JPasswordField(15);
		b1 = new JButton("Submit");
		b2 = new JButton("Refresh");
		b3 = new JButton("Exit");
		p1= new JPanel(new GridLayout(5,1));
		p1.setSize(400,230);
		p1.add(user);
		p1.add(t1);

  		p1.add(pass);
  		p1.add(t2);

        		p1.add(b1);
        		p1.add(b2);
        		p1.add(b3);

		setTitle("Login Credentials");
		add(p1);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)       
    	{  
		String userValue = t1.getText();    
		String passValue = t2.getText();    
 		if (ae.getSource()==b1)
		{
			if(userValue.equals("himshrivas") && passValue.equals("admin")) 
			{
				JOptionPane.showMessageDialog(p1,"Login Successful");
				usertab userobj=new usertab();	
			}            
			else if(userValue.equals("harshvardhanshah") && passValue.equals("admin")) 
			{
				JOptionPane.showMessageDialog(p1,"Login Successful");
				usertab userobj=new usertab();
			}
			else if (userValue.equals("manseegupta") && passValue.equals("admin")) 
        			{
				JOptionPane.showMessageDialog(p1,"Login Successful");    
				usertab userobj=new usertab();
          			}
          			else if (userValue.equals("mdrehan@") && passValue.equals("admin")) 
        			{
				JOptionPane.showMessageDialog(p1,"Login Successful");
  				usertab userobj=new usertab();  
          			}  
			else if(userValue.length()==0|| passValue.length()==0)
			{
				JOptionPane.showMessageDialog(p1,"Please fill the required fields");
			}
        			else
        			{  
            				JOptionPane.showMessageDialog(p1,"Wrong Credetials!!\nTry Again....");  
				t1.setText("");
				t2.setText("");
  			}
		}
		if(ae.getSource()==b2)
		{
				t1.setText("");
				t2.setText("");
		}
		if(ae.getSource()==b3)
		{
			System.exit(0);
		}
	}
}
class tabinfo extends JFrame implements ActionListener
{
	JPanel tabp1;
	JButton tb1,tb2,tb3,tb4,tb5;
	ImageIcon dimg,pimg,paimg,bimg,simg;
	 tabinfo()
	{
		setTitle("Information about Hospital");
		setSize(1600,900);
		setVisible(true);
		tabp1=new JPanel();
		add(tabp1);
		dimg=new ImageIcon("C:\\JAVAHMS\\doctorimg.jpg");
		pimg=new ImageIcon("C:\\JAVAHMS\\patientimg.jpg");
		paimg=new ImageIcon("C:\\JAVAHMS\\patientadmitimg.jpg");
		simg=new ImageIcon("C:\\JAVAHMS\\serviceimg.jpg");
		bimg=new ImageIcon("C:\\JAVAHMS\\billimg.jpg");
		
		tb1 = new JButton(dimg);
        		tb2 = new JButton(pimg);
        		tb3 = new JButton(paimg);
        		tb4 = new JButton(simg);
        		tb5 = new JButton(bimg);

		tb1.setBounds(207,124,50,50);
		tb2.setBounds(142,132,50,50);
		tb3.setBounds(164,120,50,50);
		tb4.setBounds(165,160,50,50);
		tb5.setBounds(191,127,50,50);

		tabp1.add(tb1);
		tabp1.add(tb2);
		tabp1.add(tb3);
		tabp1.add(tb4);
		tabp1.add(tb5);
		
 		tb1.addActionListener(this);
        		tb2.addActionListener(this);
        		tb3.addActionListener(this);
        		tb4.addActionListener(this);
        		tb5.addActionListener(this);
	}
    	public void actionPerformed(ActionEvent ae)       
    	{  

              		if(ae.getSource()==tb1)
		{
			Doctor dobj=new Doctor();				
		}
              		if(ae.getSource()==tb2)
		{
			patient pobj=new patient();					
		}
              		if(ae.getSource()==tb3)
		{
			patientadmit pobj=new patientadmit();					
		}
              		if(ae.getSource()==tb4)
		{
			service sobj=new service();				
		}
              		if(ae.getSource()==tb5)
		{
			bill bobj=new bill();					
		}
 	}
}
class usertab extends JFrame implements ActionListener
{
	JPanel userp1;
	JLabel wl1;
 	JButton ub1,ub2;
	ImageIcon wimg;
	usertab()
	{
		setSize(1360,624);
		setVisible(true);
		setLayout(new FlowLayout());
	
		userp1=new JPanel();
		
		wimg=new ImageIcon("C:\\JAVAHMS\\hms1.jpg");
		wl1=new JLabel(wimg);

		wl1.setBounds(1360,624,500,500);

		ub1=new JButton("NEXT");
		ub2=new JButton("BACK");
		add(userp1);
		userp1.add(wl1);

		ub1.setBounds(50,50,100,50);
		ub2.setBounds(50,50,100,50);
		add(ub1);
		add(ub2);
		setTitle("Welcome Page");
		ub1.addActionListener(this);
		ub2.addActionListener(this);
   	}
    	public void actionPerformed(ActionEvent ae)       
	{
		try
		{
			if(ae.getSource()==ub1)
			{
				tabinfo tbobj=new tabinfo();
			}
			if(ae.getSource()==ub2)
			{
				Logintab it= new Logintab();
			}
		}
		catch(Exception e)
        		{
            			JOptionPane.showMessageDialog(null, e.getMessage());
        		}
	}
}
public class HMS 
{
    	public static void main(String[] args) 
    	{
		try
        		{
            			Logintab it= new Logintab();
		}
        		catch(Exception e)
        		{
            			JOptionPane.showMessageDialog(null, e.getMessage());
        		}
	}
}
