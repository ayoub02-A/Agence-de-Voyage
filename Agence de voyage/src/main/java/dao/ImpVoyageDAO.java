package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import metier.Clients;
import metier.Voyage;

public class ImpVoyageDAO implements IVoyageDao {
	
	Connection connection = DAOFACTORY.getConnection();

	

	@Override
	public Voyage rejoindreVoyage(int id_Client ,int id_voyage) {
		// TODO Auto-generated method stub
		try {
		PreparedStatement ps = connection.prepareStatement("UPDATE panier SET voyage_confirme=1 WHERE fk_id_client=? and fk_id_voyage=?  ");
			ps.setInt(1, id_Client);
			ps.setInt(2, id_voyage);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Voyage> liste_Voyage() {
		// TODO Auto-generated method stub
		List<Voyage> Voyage = new ArrayList<Voyage>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from voyage where date_depart >= ? ;");
			//ps.setString(1, v.getDestination());
			ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
				v.setPrix(rs.getFloat("prix"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
			//	v.setPhoto_voyage(rs.getBlob("photo_voyage"));
				InputStream inputStream = rs.getBinaryStream("photo_voyage");
				
				 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                try {
						while ((bytesRead = inputStream.read(buffer)) != -1) {
						    outputStream.write(buffer, 0, bytesRead);                  
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						byte[] imageBytes = outputStream.toByteArray();
		                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		                 
		                 
		                try {
							inputStream.close();
							 outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
						
						
		                v.setBase64Image(base64Image);

				Voyage.add(v);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return Voyage;
	}




	@Override
	public List<Voyage> chercherVoyage(Voyage v) {
		// TODO Auto-generated method stub
		List<Voyage> l = new ArrayList<Voyage>();
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(" select * from  (select * from voyage  v ,type_de_voyage  tv where destination LIKE ? AND duree LIKE ? OR destination LIKE ? and duree LIKE ? AND budget LIKE ? OR destination LIKE ? and duree LIKE ? AND budget LIKE ? AND fk_id_typev=? AND v.fk_id_typev=tv.id_typev OR duree LIKE ? AND budget LIKE ?  OR duree LIKE ? AND budget LIKE ? AND fk_id_typev=? AND v.fk_id_typev=tv.id_typev OR budget LIKE ? AND fk_id_typev=? AND v.fk_id_typev=tv.id_typev )where date_depart >= ?;");
			ps.setString(1, v.getDestination());
			ps.setString(2, v.getDuree());
			ps.setFloat(3, v.getBudget());
			ps.setDate(4, v.getDate_depart());
			ps.setInt(5, v.getFk_id_typev()); 
			ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
	 		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				v = new Voyage();
				
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setDestination(rs.getString("destination"));
				v.setNom_voyage(rs.getString("nom_voyage"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
			    v.setFk_id_typev(rs.getInt("fk_id_typev"));
			    l.add(v);
			 
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Voyage> liste_Voyage_TypeVoyage(int fk_idtypev) {
		// TODO Auto-generated method stub
		List<Voyage> Voyage = new ArrayList<Voyage>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from voyage  where fk_id_typev=? and date_depart >= ?;");
			ps.setInt(1, fk_idtypev);	
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
				v.setPrix(rs.getFloat("prix"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
			//	v.setPhoto_voyage(rs.getBlob("photo_voyage"));
				InputStream inputStream = rs.getBinaryStream("photo_voyage");
				
				 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                try {
						while ((bytesRead = inputStream.read(buffer)) != -1) {
						    outputStream.write(buffer, 0, bytesRead);                  
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						byte[] imageBytes = outputStream.toByteArray();
		                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		                 
		                 
		                try {
							inputStream.close();
							 outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
						
						
		                v.setBase64Image(base64Image);

				Voyage.add(v);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Voyage);
		return Voyage;


	}

	@Override
	public List<Voyage> liste_Voyage_Theme(int fk_idthemev) {
		// TODO Auto-generated method stub
		List<Voyage> Voyage = new ArrayList<Voyage>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from voyage  where fk_id_vtheme=? and date_depart >= ?;");
			ps.setInt(1, fk_idthemev);		
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
				v.setPrix(rs.getFloat("prix"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
			//	v.setPhoto_voyage(rs.getBlob("photo_voyage"));
				InputStream inputStream = rs.getBinaryStream("photo_voyage");
				
				 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                try {
						while ((bytesRead = inputStream.read(buffer)) != -1) {
						    outputStream.write(buffer, 0, bytesRead);                  
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						byte[] imageBytes = outputStream.toByteArray();
		                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		                 
		                 
		                try {
							inputStream.close();
							 outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
						
						
		                v.setBase64Image(base64Image);

				Voyage.add(v);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Voyage);
		return Voyage;
	}

	@Override
	public List<Voyage> liste_Voyage_Hebergement(int fk_idheberv) {
		// TODO Auto-generated method stub
		List<Voyage> Voyage = new ArrayList<Voyage>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from voyage  where fk_id_heberg=? and date_depart >= ?;");
			ps.setInt(1, fk_idheberv);		
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
				v.setPrix(rs.getFloat("prix"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
			//	v.setPhoto_voyage(rs.getBlob("photo_voyage"));
				InputStream inputStream = rs.getBinaryStream("photo_voyage");
				
				 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                try {
						while ((bytesRead = inputStream.read(buffer)) != -1) {
						    outputStream.write(buffer, 0, bytesRead);                  
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						byte[] imageBytes = outputStream.toByteArray();
		                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		                 
		                 
		                try {
							inputStream.close();
							 outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
						
						
		                v.setBase64Image(base64Image);

				Voyage.add(v);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Voyage);
		return Voyage;
	}

	@Override
	public List<Voyage> liste_Voyage(int id_Voyage) {
		// TODO Auto-generated method stub
		List<Voyage> Voyage = new ArrayList<Voyage>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from voyage where id_Voyage=? ;");
			ps.setInt(1, id_Voyage);		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Voyage v = new Voyage();
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
				v.setPrix(rs.getFloat("prix"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
			//	v.setPhoto_voyage(rs.getBlob("photo_voyage"));

				
				

				InputStream inputStream = rs.getBinaryStream("photo_voyage");
				
				 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                try {
						while ((bytesRead = inputStream.read(buffer)) != -1) {
						    outputStream.write(buffer, 0, bytesRead);                  
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						byte[] imageBytes = outputStream.toByteArray();
		                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		                 
		                 
		                try {
							inputStream.close();
							 outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
						
						
		                v.setBase64Image(base64Image);

				Voyage.add(v);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Voyage);
		return Voyage;


	}

	@Override
	public List<Voyage> liste_VoyagePanier(int idClient) {
		// TODO Auto-generated method stub
				List<Voyage> Voyage = new ArrayList<Voyage>();
				Connection conn = DAOFACTORY.getConnection();
				try {
					PreparedStatement ps = conn.prepareStatement("select distinct T.* from  voyage T, panier B where B.fk_id_client = ?  and B.fk_id_voyage = T.id_voyage and B.voyage_confirme = 0  and T.date_depart >= ?");
					ps.setInt(1, idClient);		
					ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Voyage v = new Voyage();
						v.setId_voyage(rs.getInt("id_voyage"));
						v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
						v.setDestination(rs.getString("destination"));
						v.setDuree(rs.getString("duree"));
						v.setDate_depart(rs.getDate("date_depart"));
						v.setBudget(rs.getFloat("budget"));
						v.setPrix(rs.getFloat("prix"));
						v.setNbr_participant(rs.getInt("nbr_participant"));
						v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
						v.setFk_id_typev(rs.getInt("fk_id_typev"));
						v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
						v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
					//	v.setPhoto_voyage(rs.getBlob("photo_voyage"));
						InputStream inputStream = rs.getBinaryStream("photo_voyage");
						
						 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							byte[] buffer = new byte[4096];
			                int bytesRead = -1;
			                 
			                try {
								while ((bytesRead = inputStream.read(buffer)) != -1) {
								    outputStream.write(buffer, 0, bytesRead);                  
								}
								
								
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								byte[] imageBytes = outputStream.toByteArray();
				                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				                 
				                 
				                try {
									inputStream.close();
									 outputStream.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				               
								
								
				                v.setBase64Image(base64Image);

						Voyage.add(v);	
					}
					ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(Voyage);
				return Voyage;
	}
	
	@Override
	public Voyage getVoyage(int id_voyage) {
		// TODO Auto-generated method stub
		Voyage v = new Voyage();
		try {
		PreparedStatement ps = connection.prepareStatement("SELECT * from voyage where id_Voyage=? ;");
			ps.setInt(1, id_voyage);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				v.setId_voyage(rs.getInt("id_voyage"));
				v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
				v.setDestination(rs.getString("destination"));
				v.setDuree(rs.getString("duree"));
				v.setDate_depart(rs.getDate("date_depart"));
				v.setBudget(rs.getFloat("budget"));
				v.setPrix(rs.getFloat("prix"));
				v.setNbr_participant(rs.getInt("nbr_participant"));
				v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
				v.setFk_id_typev(rs.getInt("fk_id_typev"));
				v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
				v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
			//	v.setPhoto_voyage(rs.getBlob("photo_voyage"));
				InputStream inputStream = rs.getBinaryStream("photo_voyage");
				
				 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                try {
						while ((bytesRead = inputStream.read(buffer)) != -1) {
						    outputStream.write(buffer, 0, bytesRead);                  
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						byte[] imageBytes = outputStream.toByteArray();
		                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		                 
		                 
		                try {
							inputStream.close();
							 outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               
						
						
		                v.setBase64Image(base64Image);
			}}


		 catch (SQLException e1) {
			e1.printStackTrace();
		}
		return v;
		
	}
		
		@Override
		public List<Voyage> liste_VoyageConfirmer(int idClient) {
			// TODO Auto-generated method stub
					List<Voyage> Voyage = new ArrayList<Voyage>();
					Connection conn = DAOFACTORY.getConnection();
					try {
						PreparedStatement ps = conn.prepareStatement("select distinct T.* from  voyage T, panier B where B.fk_id_client = ?  and B.fk_id_voyage = T.id_voyage and B.voyage_confirme = 1  and T.date_depart >= ?");
						ps.setInt(1, idClient);		
						ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							Voyage v = new Voyage();
							v.setId_voyage(rs.getInt("id_voyage"));
							v.setNom_voyage(rs.getString("nom_voyage"));//noms de la base de donnés
							v.setDestination(rs.getString("destination"));
							v.setDuree(rs.getString("duree"));
							v.setDate_depart(rs.getDate("date_depart"));
							v.setBudget(rs.getFloat("budget"));
							v.setPrix(rs.getFloat("prix"));
							v.setNbr_participant(rs.getInt("nbr_participant"));
							v.setFk_id_circuit(rs.getInt("fk_id_circuit"));
							v.setFk_id_typev(rs.getInt("fk_id_typev"));
							v.setFk_id_heberg(rs.getInt("fk_id_heberg"));
							v.setFk_id_vtheme(rs.getInt("fk_id_vtheme"));
							//v.setPhoto_voyage(rs.getBlob("photo_voyage"));
							InputStream inputStream = rs.getBinaryStream("photo_voyage");
							
							 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
								byte[] buffer = new byte[4096];
				                int bytesRead = -1;
				                 
				                try {
									while ((bytesRead = inputStream.read(buffer)) != -1) {
									    outputStream.write(buffer, 0, bytesRead);                  
									}
									
									
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
									byte[] imageBytes = outputStream.toByteArray();
					                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					                 
					                 
					                try {
										inputStream.close();
										 outputStream.close();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					               
									
									
					                v.setBase64Image(base64Image);

							Voyage.add(v);	
						}
						ps.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(Voyage);
					return Voyage;
		

}

		@Override
		public List<Voyage> chercherVoyage(Voyage v, String budget, String type) {
			// TODO Auto-generated method stub
			List<Voyage> l = new ArrayList<Voyage>();
			
			
			try {
				PreparedStatement ps = connection.prepareStatement(" select * from voyage  v where date_depart = ? or destination = ? or duree = ? OR  budget <= ? or fk_id_typev = ?");
				ps.setDate(1, v.getDate_depart());
				System.out.println("hna "+v.getDate_depart());
				ps.setString(2, v.getDestination());
				ps.setString(3, v.getDuree());
				ps.setString(4, budget);
				ps.setString(5, type);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					v = new Voyage();
					
					v.setId_voyage(rs.getInt("id_voyage"));
					v.setDestination(rs.getString("destination"));
					v.setNom_voyage(rs.getString("nom_voyage"));
					v.setDuree(rs.getString("duree"));
					v.setDate_depart(rs.getDate("date_depart"));
					v.setNbr_participant(rs.getInt("nbr_participant")-nbrPlace(rs.getInt("id_voyage")));
					v.setBudget(rs.getFloat("budget"));
				    v.setFk_id_typev(rs.getInt("fk_id_typev"));
				  //  v.setPhoto_voyage(rs.getBlob("photo_voyage"));
					InputStream inputStream = rs.getBinaryStream("photo_voyage");
					
					 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[4096];
		                int bytesRead = -1;
		                 
		                try {
							while ((bytesRead = inputStream.read(buffer)) != -1) {
							    outputStream.write(buffer, 0, bytesRead);                  
							}
							
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							byte[] imageBytes = outputStream.toByteArray();
			                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			                 
			                 
			                try {
								inputStream.close();
								 outputStream.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			               
							
							
			                v.setBase64Image(base64Image);
				    l.add(v);
				 
				}
				ps.close();
				
				System.out.println("hna 2 : "+l);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return l;
			
		}
		
		@Override
		public int nbrPlace(int idVoyage) {
			// TODO Auto-generated method stub
			int nbr=0;
			try {
				PreparedStatement ps= connection.prepareStatement("SELECT COUNT(fk_id_client) FROM panier where fk_id_voyage = ? and voyage_confirme = '1'");
				ps.setInt(1,idVoyage);
				ResultSet rs = ps.executeQuery();
				if  (rs.next()) {
					nbr=rs.getInt("COUNT(fk_id_client)");
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return nbr;
		}

		@Override
		public void addVoyage(Voyage v) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Voyage> listeVoyage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voyage> listeVoyageExpir() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<String> listeVoyagDest() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voyage> listeVoyageParDEst(String dest) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voyage> listeVoyageParDate(String date) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voyage> listeVoyageParTheme(String idtheme) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voyage> listeVoyageParType(String idtype) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void updateVoyage(int id, Voyage v) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteVoyage(int id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Voyage> listeVoyageParCircuit(int idCircuit) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voyage> listeVoyageParCircuitExpirer(int idCircuit) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Clients> listeParticipants(int idVoyage) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nbrClient() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int nbrVoyage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int nbrCircuit() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int nbrTheme() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int nbrType() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int nbrHeberg() {
			// TODO Auto-generated method stub
			return 0;
		}
		}
