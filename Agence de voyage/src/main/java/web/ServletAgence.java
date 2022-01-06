package web;

import java.io.IOException;




import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.sql.Date;


import java.util.*;

import dao.CircuitAccompagnesAdminDaoImpl;
import dao.ClientsDaoImpl;
import dao.LoginAdminDao;
import dao.ThemeVoyageDaoImpl;
import dao.TypeVoyageDaoImpl;
import dao.VoyageDaoImpl;
import dao.HebergementDaoImpl;
import metier.Administrateur;
import metier.CercuitVoyagePdf;
import metier.CircuitPdf;
import metier.Circuit_accompagnes;
import metier.Clients;
import metier.Hebergement;
import metier.Voyage_a_themes;
import metier.Type_de_Voyage;
import metier.Voyage;
import web.model;

/**
 * Servlet implementation class ServletAgence
 */
@WebServlet(urlPatterns = {"/loginAdmin","/logoutAdmin","/listClients","/ClientParMc","/AddNewheberg","/ListHeberg"
		,"/DeleteHeberg","/ListTheme","/AddNewTheme","/DeleteThemes","/ListType","/AddNewType","/DeleteType",
		"/ListCircuit","/AddCircuit","/DeleteCircuit","/Details_circuit","/PupdateCircuit","/updateCircuit"
		,"/pdfCircuit","/ListVoyage","/AddVoyage","/Details_voyage","/PupdateVoyage","/updateVoyage"
		,"/deleteVoyage","/listVoyageExpir","/detailsVoyageExpir","/deleteVoyageExpir","/VoyageParDate"
		,"/VoyageParDest","/VoyageParTheme","/VoyageParType","/VoyageCercuit","/pdfVoyageCercuit"
		,"/panierVoyage"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ServletAgence extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginAdminDao loginAdmin;
	private ClientsDaoImpl clientsdao;
	private HebergementDaoImpl hebergementdao;
	private ThemeVoyageDaoImpl themedao;
	private TypeVoyageDaoImpl typedao;
	private CircuitAccompagnesAdminDaoImpl circuitdao;
	private model model;
	private VoyageDaoImpl voyagedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgence() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	loginAdmin=new LoginAdminDao();
    	clientsdao=new ClientsDaoImpl();
    	hebergementdao=new HebergementDaoImpl();
    	themedao=new ThemeVoyageDaoImpl();
    	typedao=new TypeVoyageDaoImpl();
    	circuitdao=new CircuitAccompagnesAdminDaoImpl();
    	model=new model();
    	voyagedao=new VoyageDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.print("Path : " + request.getServletPath());
		System.out.println();
		
		// login admin 
		
		if(request.getServletPath().equals("/loginAdmin")) {
			
			String email_admin = request.getParameter("email_admin");
			String mdp_admin = request.getParameter("mdp_admin");
			System.out.println("email_admin :" + email_admin);
			System.out.println("mdp_admin :" + mdp_admin);
			Administrateur loginA= new Administrateur();
			loginA.setEmail_admin(email_admin);
			loginA.setMdp_admin(mdp_admin);
			
			try {
				if(loginAdmin.login(loginA)) {
					HttpSession session = request.getSession();
					System.out.println("session created");
					session.setAttribute("nom","Administrateur");
					System.out.println("session ok");
					response.sendRedirect("indexAdmin.jsp");
				}
				else {
					request.setAttribute("msg1", "email ou mot de passe incorrect ");
					this.getServletContext().getRequestDispatcher("/loginAdmin.jsp").forward(request, response);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				response.sendRedirect("page_404.jsp");
				e.printStackTrace();
			}
		}
		else
			if(request.getServletPath().equals("/logoutAdmin")) {
				try {
					HttpSession session=request.getSession();  
					session.invalidate();  
					System.out.println("session killed");
					response.sendRedirect("loginAdmin.jsp");
				}
				catch (Exception e) {
					// TODO: handle exception
					response.sendRedirect("page_404.jsp");
					e.printStackTrace();
				}
			}
			else
				if(request.getServletPath().equals("/listClients")) {
					try {
						List<Clients> clients=clientsdao.listeClients();
						request.setAttribute("clients", clients);
						System.out.println(clients);
						request.getRequestDispatcher("gestion_clients_Admin.jsp").forward(request, response);
					}
					catch (Exception e) {
						// TODO: handle exception
						response.sendRedirect("page_404.jsp");
						e.printStackTrace();
					}
				}
				else
					if(request.getServletPath().equals("/ClientParMc")) {
						try {
							String mc=request.getParameter("mc");	
							System.out.println("MC : "+mc);
							List<Clients> clients=clientsdao.ClientsParMC(mc);
							request.setAttribute("clients", clients);
							System.out.println(clients);
							request.getRequestDispatcher("gestion_clients_Admin.jsp").forward(request, response);
						}
						catch (Exception e) {
							// TODO: handle exception
							response.sendRedirect("page_404.jsp");
							e.printStackTrace();
						}
					}
					else
						if(request.getServletPath().equals("/AddNewheberg")) {
							try {
								String newHeberg=request.getParameter("newHeberg");
								System.out.println("newHeberg :" + newHeberg);
								Hebergement hebergement=new Hebergement();
								hebergement.setNom_heberg(newHeberg);
								hebergementdao.addHebergement(hebergement);
								request.getRequestDispatcher("/ListHeberg").forward(request, response);
							}
							catch (Exception e) {
								// TODO: handle exception
								response.sendRedirect("page_404.jsp");
								e.printStackTrace();
							}
						}
						else
							if(request.getServletPath().equals("/ListHeberg")) {
								try {
									List<Hebergement> hebergement=hebergementdao.listeHebergement();
									System.out.println(hebergement);
									request.setAttribute("hebergement", hebergement);
									request.getRequestDispatcher("gestion_type_hebergement_Admin.jsp").forward(request, response);
								}
								catch (Exception e) {
									// TODO: handle exception
									response.sendRedirect("page_404.jsp");
									e.printStackTrace();
								}
							}
							else
								if(request.getServletPath().equals("/DeleteHeberg")) {
									try {
										int idHeberg = Integer.parseInt(request.getParameter("idHeberg"));
										hebergementdao.deleteHebergement(idHeberg);
										System.out.println("idHeberg : " + idHeberg);
										request.getRequestDispatcher("/ListHeberg").forward(request, response);
									}
									catch (Exception e) {
										// TODO: handle exception
										response.sendRedirect("page_404.jsp");
										e.printStackTrace();
									}
								}
								else
									if(request.getServletPath().equals("/ListTheme")) {
										try {
											List<Voyage_a_themes> vThemes=themedao.listeTheme();
											System.out.println(vThemes);
											request.setAttribute("vThemes", vThemes);
											request.getRequestDispatcher("gestion_themes.jsp").forward(request, response);
										}
										catch (Exception e) {
											// TODO: handle exception
											response.sendRedirect("page_404.jsp");
											e.printStackTrace();
										}
									}
									else
										if(request.getServletPath().equals("/AddNewTheme")) {
											try {
												String newTheme=request.getParameter("newTheme");
												System.out.println("newTheme :" + newTheme);
												Voyage_a_themes themes=new Voyage_a_themes();
												themes.setNom_theme(newTheme);
												themedao.addTheme(themes);
												request.getRequestDispatcher("/ListTheme").forward(request, response);
											}
											catch (Exception e) {
												// TODO: handle exception
												response.sendRedirect("page_404.jsp");
												e.printStackTrace();
											}
										}
										else
											if(request.getServletPath().equals("/DeleteThemes")) {
												try {
													int idTheme = Integer.parseInt(request.getParameter("idTheme"));
													themedao.deleteTheme(idTheme);
													System.out.println("idTheme : " + idTheme);
													request.getRequestDispatcher("/ListTheme").forward(request, response);
												}
												catch (Exception e) {
													// TODO: handle exception
													response.sendRedirect("page_404.jsp");
													e.printStackTrace();
												}
											}
											else
												if(request.getServletPath().equals("/ListType")) {
													try {
														List<Type_de_Voyage> vType=typedao.listeTypeVoyage();
														System.out.println(vType);
														request.setAttribute("vType", vType);
														request.getRequestDispatcher("gestion_type_voyage.jsp").forward(request, response);
													}
													catch (Exception e) {
														// TODO: handle exception
														response.sendRedirect("page_404.jsp");
														e.printStackTrace();
													}
												}
												else
													if(request.getServletPath().equals("/AddNewType")) {
														try {
															String newType=request.getParameter("newType");
															System.out.println("newTheme :" + newType);
															Type_de_Voyage type=new Type_de_Voyage();
															type.setNom_typev(newType);
															typedao.addTypeVoyage(type);
															request.getRequestDispatcher("/ListType").forward(request, response);
														}
														catch (Exception e) {
															// TODO: handle exception
															response.sendRedirect("page_404.jsp");
															e.printStackTrace();
														}
													}
													else
														if(request.getServletPath().equals("/DeleteType")) {
															try {
																int idType = Integer.parseInt(request.getParameter("idType"));
																typedao.deleteTypeVoyage(idType);
																System.out.println("idType : " + idType);
																request.getRequestDispatcher("/ListType").forward(request, response);
															}
															catch (Exception e) {
																// TODO: handle exception
																response.sendRedirect("page_404.jsp");
																e.printStackTrace();
															}
														}
														else
															if(request.getServletPath().equals("/ListCircuit")) {
																try {
																	List<Circuit_accompagnes> circuitA=circuitdao.listeCircuit();
																	System.out.println(circuitA);
																	request.setAttribute("circuitA", circuitA);
																	request.getRequestDispatcher("/addCircuit_accompagnesAdmin.jsp").forward(request, response);
																}
																catch (Exception e) {
																	// TODO: handle exception
																	response.sendRedirect("page_404.jsp");
																	e.printStackTrace();
																}
															}
															else
																if(request.getServletPath().equals("/AddCircuit")) {
																	try {
																		String nom=request.getParameter("nom");
																		String email=request.getParameter("email");
																		String telephone=request.getParameter("telephone");
																		String langues=request.getParameter("langues");
																		Part photo = request.getPart("photo");
																		String descrip=request.getParameter("descrip");
																		InputStream   photoInputStream=null;
																		if (photo != null) {
																			photoInputStream = photo.getInputStream();
																		}
																		System.out.println("nom :"+nom);
																		System.out.println("email :"+email);
																		System.out.println("telephone :"+telephone);
																		System.out.println("langues :"+langues);
																		System.out.println("descrip :"+descrip);
																		
																		Circuit_accompagnes circuit=new Circuit_accompagnes();
																		
																		circuit.setNom_circuit(nom);
																		circuit.setEmail_circuit(email);
																		circuit.setTel_circuit(telephone);
																		circuit.setLangues_circuit(langues);
																		circuit.setPhoto_circuit(photoInputStream);
																		circuit.setDescription_circuit(descrip);
																		
																		circuitdao.addCircuit(circuit);
																		request.getRequestDispatcher("/ListCircuit").forward(request, response);
																		}
																	catch (Exception e) {
																		// TODO: handle exception
																		response.sendRedirect("page_404.jsp");
																		e.printStackTrace();
																	}
																}
																else
																	if(request.getServletPath().equals("/DeleteCircuit")) {
																		try {
																			int idCircuit = Integer.parseInt(request.getParameter("idCircuit"));
																			circuitdao.deleteCircuit(idCircuit);
																			System.out.println("idCircuit : " + idCircuit);
																			request.getRequestDispatcher("/ListCircuit").forward(request, response);
																		}
																		catch (Exception e) {
																			// TODO: handle exception
																			response.sendRedirect("page_404.jsp");
																			e.printStackTrace();
																		}
																	}
																	else
																		if(request.getServletPath().equals("/Details_circuit")) {
																			try {
																				int idCircuit = Integer.parseInt(request.getParameter("idCircuit"));
																				request.setAttribute("circuitA", circuitdao.getCircuit(idCircuit));
																				request.getRequestDispatcher("/details_circuit.jsp").forward(request, response);
																			}
																			catch (Exception e) {
																				// TODO: handle exception
																				response.sendRedirect("page_404.jsp");
																				e.printStackTrace();
																			}
																		}
																		else
																			if(request.getServletPath().equals("/PupdateCircuit")) {
																				try {
																					int idCircuit = Integer.parseInt(request.getParameter("idCircuit"));
																					model.setIdC(idCircuit);
																					request.setAttribute("circuitA", circuitdao.getCircuit(idCircuit));
																					request.getRequestDispatcher("/updateCircuit.jsp").forward(request, response);
																				}
																				catch (Exception e) {
																					// TODO: handle exception
																					response.sendRedirect("page_404.jsp");
																					e.printStackTrace();
																				}
																			}
																			else
																				if(request.getServletPath().equals("/updateCircuit")) {
																					try {
																						String nom=request.getParameter("nom");
																						String email=request.getParameter("email");
																						String telephone=request.getParameter("telephone");
																						String langues=request.getParameter("langues");
																						String descrip=request.getParameter("descrip");
																						
																						System.out.println("nom :"+nom);
																						System.out.println("email :"+email);
																						System.out.println("telephone :"+telephone);
																						System.out.println("langues :"+langues);
																						System.out.println("descrip :"+descrip);
																						
																						Circuit_accompagnes circuit=new Circuit_accompagnes();
																						
																						circuit.setNom_circuit(nom);
																						circuit.setEmail_circuit(email);
																						circuit.setTel_circuit(telephone);
																						circuit.setLangues_circuit(langues);
																						circuit.setDescription_circuit(descrip);
																						
																						circuitdao.updateCircuit(model.getIdC(), circuit);
																						request.getRequestDispatcher("/ListCircuit").forward(request, response);
																					}
																					catch (Exception e) {
																						// TODO: handle exception
																						response.sendRedirect("page_404.jsp");
																						e.printStackTrace();
																					}
																				}
																				else
																					if(request.getServletPath().equals("/pdfCircuit")) {
																						try {
																							response.setContentType("application/pdf");
																							DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
																							String currentDateTime = dateFormatter.format(new java.util.Date());
																							String headerKey = "Content-Disposition";
																							String headerValue = "attachment; filename=liste " + currentDateTime + ".pdf";
																							response.setHeader(headerKey, headerValue);
																							List<Circuit_accompagnes> circuitA=circuitdao.listeCircuit();
																							CircuitPdf exporter = new CircuitPdf(circuitA);
																							exporter.export(response);
																						}
																						catch(Exception e) {
																							response.sendRedirect("page_404.jsp");
																							e.printStackTrace();
																						}
																					}
																					else
																						if(request.getServletPath().equals("/ListVoyage")) {
																							try {
																								List<String> Destination= voyagedao.listeVoyagDest();
																								
																								List<Circuit_accompagnes> circuitA=circuitdao.listeCircuitAvailable();
																								List<Type_de_Voyage> vType=typedao.listeTypeVoyage();
																								List<Voyage_a_themes> vThemes=themedao.listeTheme();
																								List<Hebergement> hebergement=hebergementdao.listeHebergement();
																								request.setAttribute("circuitA", circuitA);
																								request.setAttribute("vType", vType);
																								request.setAttribute("hebergement", hebergement);
																								request.setAttribute("vThemes", vThemes);
																								request.setAttribute("Destination", Destination);
																								
																								List<Voyage> lvoyage=voyagedao.listeVoyage();
																								System.out.println("chuf : "+lvoyage);
																								
																								request.setAttribute("lvoyage", lvoyage);
																								
																								
																								
																								request.getRequestDispatcher("/AddVoyageAdmin.jsp").forward(request, response);
																							}
																							catch(Exception e) {
																								response.sendRedirect("page_404.jsp");
																								e.printStackTrace();
																							}
																						}
																						else
																							if(request.getServletPath().equals("/AddVoyage")) {
																								try {
																									String titre=request.getParameter("nom");
																									String destination=request.getParameter("destination");
																									String Duree=request.getParameter("Duree");
																									Date date= Date.valueOf(request.getParameter("date"));
																									System.out.println(date);
																									int Budget=Integer.parseInt(request.getParameter("Budget"));
																									int number=Integer.parseInt(request.getParameter("number"));
																									int prix=Integer.parseInt(request.getParameter("prix"));
																									int idCircuit=Integer.parseInt(request.getParameter("Circuit"));
																									int idType=Integer.parseInt(request.getParameter("Type"));
																									int idhebergement=Integer.parseInt(request.getParameter("hebergement"));
																									int idTheme=Integer.parseInt(request.getParameter("Theme"));
																									Part photo = request.getPart("photo");
																									InputStream   photoInputStream=null;
																									if (photo != null) {
																										photoInputStream = photo.getInputStream();
																									}
																									
																									
																									System.out.println("titre :"+titre);
																									System.out.println("destination :"+destination);
																									System.out.println("Duree :"+Duree);
																									System.out.println("Budget :"+Budget);
																									System.out.println("number :"+number);
																									System.out.println("prix :"+prix);
																									System.out.println("idCircuit :"+idCircuit);
																									System.out.println("idType :"+idType);
																									System.out.println("idhebergement :"+idhebergement);
																									System.out.println("idTheme :"+idTheme);
																									
																									
																									Voyage v=new Voyage();
																									
																									v.setNom_voyage(titre);
																									v.setDestination(destination);
																									v.setDuree(Duree);
																									v.setDate_depart(date);
																									v.setBudget(Budget);
																									v.setNbr_participant(number);
																									v.setPrix(prix);
																									v.setFk_id_circuit(idCircuit);
																									v.setFk_id_typev(idType);
																									v.setFk_id_heberg(idhebergement);
																									v.setFk_id_vtheme(idTheme);
																									v.setPhoto_voyage(photoInputStream);
																									
																									voyagedao.addVoyage(v);
																									request.getRequestDispatcher("/ListVoyage").forward(request, response);
																								}
																								catch(Exception e) {
																									response.sendRedirect("page_404.jsp");
																									e.printStackTrace();
																								}
																							}
																							else
																								if(request.getServletPath().equals("/Details_voyage")) {
																									try {
																										int idVoyage=Integer.parseInt(request.getParameter("idVoyage"));
																										String nomCircuit= circuitdao.getCircuit(voyagedao.getVoyage(idVoyage).getFk_id_circuit()).getNom_circuit();
																										String nomTheme= themedao.getTheme(voyagedao.getVoyage(idVoyage).getFk_id_vtheme()).getNom_theme();
																										String nomHeberg= hebergementdao.getHeberg(voyagedao.getVoyage(idVoyage).getFk_id_heberg()).getNom_heberg();
																										String nomType= typedao.getType(voyagedao.getVoyage(idVoyage).getFk_id_typev()).getNom_typev();
																										
																										request.setAttribute("nomCircuit", nomCircuit);
																										request.setAttribute("nomTheme", nomTheme);
																										request.setAttribute("nomHeberg", nomHeberg);
																										request.setAttribute("nomType", nomType);
																										request.setAttribute("voyage", voyagedao.getVoyage(idVoyage));
																										request.getRequestDispatcher("/details_voyage.jsp").forward(request, response);
																									}
																									catch(Exception e) {
																										response.sendRedirect("page_404.jsp");
																										e.printStackTrace();
																									}
																								}
																								else
																									if(request.getServletPath().equals("/PupdateVoyage")) {
																										try {
																											int idVoyage = Integer.parseInt(request.getParameter("idVoyage"));
																											model.setIdV(idVoyage);
																											request.setAttribute("circuitAct", circuitdao.getCircuit(voyagedao.getVoyage(idVoyage).getFk_id_circuit()));
																											request.setAttribute("circuitA", circuitdao.listeCircuitAvailable());
																											request.setAttribute("voyage", voyagedao.getVoyage(idVoyage));
																											request.getRequestDispatcher("/updateVoyage.jsp").forward(request, response);
																										}
																										catch (Exception e) {
																											// TODO: handle exception
																											response.sendRedirect("page_404.jsp");
																											e.printStackTrace();
																										}
																									}
																									else
																										if(request.getServletPath().equals("/updateVoyage")) {
																											try {
																												String Duree=request.getParameter("Duree");
																												Date date=Date.valueOf(request.getParameter("date"));
																												float Budget=Float.parseFloat(request.getParameter("Budget"));
																												int number=Integer.parseInt(request.getParameter("number"));
																												float prix=Float.parseFloat(request.getParameter("prix"));
																												int idCircuit=Integer.parseInt(request.getParameter("Circuit"));
																												
																												System.out.println("Duree :"+Duree);
																												System.out.println("date :"+date);
																												System.out.println("Budget :"+Budget);
																												System.out.println("number :"+number);
																												System.out.println("prix :"+prix);
																												System.out.println("idCircuit :"+idCircuit);
																												
																												Voyage v=new Voyage();
																												
																												v.setDuree(Duree);
																												v.setDate_depart(date);
																												v.setBudget(Budget);
																												v.setNbr_participant(number);
																												v.setPrix(prix);
																												v.setFk_id_circuit(idCircuit);
																												
																												voyagedao.updateVoyage(model.getIdV(), v);
																												request.getRequestDispatcher("/ListVoyage").forward(request, response);
																											}
																											catch (Exception e) {
																												// TODO: handle exception
																												response.sendRedirect("page_404.jsp");
																												e.printStackTrace();
																											}
																										}
																										else
																											if(request.getServletPath().equals("/deleteVoyage")) {
																												try {
																													int idVoyage = Integer.parseInt(request.getParameter("idVoyage"));
																													voyagedao.deleteVoyage(idVoyage);
																													System.out.println("idVoyage : " + idVoyage);
																													request.getRequestDispatcher("/ListVoyage").forward(request, response);
																												}
																												catch (Exception e) {
																													// TODO: handle exception
																													response.sendRedirect("page_404.jsp");
																													e.printStackTrace();
																												}
																											}
																											else
																												if(request.getServletPath().equals("/listVoyageExpir")) {
																													try {
																														List<Voyage> lvoyage=voyagedao.listeVoyageExpir();
																														System.out.println("chuf : "+lvoyage);
																														request.setAttribute("lvoyage", lvoyage);
																														request.getRequestDispatcher("/voyage_expir.jsp").forward(request, response);
																													}
																													catch(Exception e) {
																														response.sendRedirect("page_404.jsp");
																														e.printStackTrace();
																													}
																												}
																												else
																													if(request.getServletPath().equals("/detailsVoyageExpir")) {
																														try {
																															int idVoyage=Integer.parseInt(request.getParameter("idVoyage"));
																															String nomCircuit= circuitdao.getCircuit(voyagedao.getVoyage(idVoyage).getFk_id_circuit()).getNom_circuit();
																															String nomTheme= themedao.getTheme(voyagedao.getVoyage(idVoyage).getFk_id_vtheme()).getNom_theme();
																															String nomHeberg= hebergementdao.getHeberg(voyagedao.getVoyage(idVoyage).getFk_id_heberg()).getNom_heberg();
																															String nomType= typedao.getType(voyagedao.getVoyage(idVoyage).getFk_id_typev()).getNom_typev();
																															
																															request.setAttribute("nomCircuit", nomCircuit);
																															request.setAttribute("nomTheme", nomTheme);
																															request.setAttribute("nomHeberg", nomHeberg);
																															request.setAttribute("nomType", nomType);
																															request.setAttribute("voyage", voyagedao.getVoyage(idVoyage));
																															request.getRequestDispatcher("/detailsVoyageExpir.jsp").forward(request, response);
																														}
																														catch (Exception e) {
																															// TODO: handle exception
																															response.sendRedirect("page_404.jsp");
																															e.printStackTrace();
																														}
																													}
																													else
																														if(request.getServletPath().equals("/deleteVoyageExpir")) {
																															try {
																																int idVoyage = Integer.parseInt(request.getParameter("idVoyage"));
																																voyagedao.deleteVoyage(idVoyage);
																																System.out.println("idVoyage : " + idVoyage);
																																request.getRequestDispatcher("/listVoyageExpir").forward(request, response);
																															}
																															catch (Exception e) {
																																// TODO: handle exception
																																response.sendRedirect("page_404.jsp");
																																e.printStackTrace();
																															}
																														}
																														else
																															if(request.getServletPath().equals("/VoyageParDate")) {
																																try {
																																	String mc=request.getParameter("mc");	
																																	System.out.println("MC : "+mc);
																																	
																																	List<String> Destination= voyagedao.listeVoyagDest();
																																	List<Circuit_accompagnes> circuitA=circuitdao.listeCircuit();
																																	List<Type_de_Voyage> vType=typedao.listeTypeVoyage();
																																	List<Voyage_a_themes> vThemes=themedao.listeTheme();
																																	List<Hebergement> hebergement=hebergementdao.listeHebergement();
																																	request.setAttribute("circuitA", circuitA);
																																	request.setAttribute("vType", vType);
																																	request.setAttribute("hebergement", hebergement);
																																	request.setAttribute("vThemes", vThemes);
																																	request.setAttribute("Destination", Destination);
																																	
																																	List<Voyage> lvoyage=voyagedao.listeVoyageParDate(mc);
																																	request.setAttribute("lvoyage", lvoyage);
																																	System.out.println("chuf : "+lvoyage);
																																	
																																	request.getRequestDispatcher("AddVoyageAdmin.jsp").forward(request, response);
																																}
																																catch (Exception e) {
																																	// TODO: handle exception
																																	response.sendRedirect("page_404.jsp");
																																	e.printStackTrace();
																																}
																															}
																															else
																																if(request.getServletPath().equals("/VoyageParDest")) {
																																	try {
																																		String mc=request.getParameter("Dest");	
																																		System.out.println("MC : "+mc);
																																		
																																		List<String> Destination= voyagedao.listeVoyagDest();
																																		List<Circuit_accompagnes> circuitA=circuitdao.listeCircuit();
																																		List<Type_de_Voyage> vType=typedao.listeTypeVoyage();
																																		List<Voyage_a_themes> vThemes=themedao.listeTheme();
																																		List<Hebergement> hebergement=hebergementdao.listeHebergement();
																																		request.setAttribute("circuitA", circuitA);
																																		request.setAttribute("vType", vType);
																																		request.setAttribute("hebergement", hebergement);
																																		request.setAttribute("vThemes", vThemes);
																																		request.setAttribute("Destination", Destination);
																																		
																																		List<Voyage> lvoyage=voyagedao.listeVoyageParDEst(mc);
																																		request.setAttribute("lvoyage", lvoyage);
																																		System.out.println("chuf : "+lvoyage);
																																		request.getRequestDispatcher("AddVoyageAdmin.jsp").forward(request, response);
																																	}
																																	catch (Exception e) {
																																		// TODO: handle exception
																																		response.sendRedirect("page_404.jsp");
																																		e.printStackTrace();
																																	}
																																}
																																else
																																	if(request.getServletPath().equals("/VoyageParTheme")) {
																																		try {
																																			//
																																			String mc=request.getParameter("Theme");	
																																			System.out.println("MC : "+mc);
																																			
																																			List<String> Destination= voyagedao.listeVoyagDest();
																																			List<Circuit_accompagnes> circuitA=circuitdao.listeCircuit();
																																			List<Type_de_Voyage> vType=typedao.listeTypeVoyage();
																																			List<Voyage_a_themes> vThemes=themedao.listeTheme();
																																			List<Hebergement> hebergement=hebergementdao.listeHebergement();
																																			request.setAttribute("circuitA", circuitA);
																																			request.setAttribute("vType", vType);
																																			request.setAttribute("hebergement", hebergement);
																																			request.setAttribute("vThemes", vThemes);
																																			request.setAttribute("Destination", Destination);
																																			
																																			List<Voyage> lvoyage=voyagedao.listeVoyageParTheme(mc);
																																			request.setAttribute("lvoyage", lvoyage);
																																			System.out.println("chuf : "+lvoyage);
																																			request.getRequestDispatcher("AddVoyageAdmin.jsp").forward(request, response);
																																		}
																																		catch (Exception e) {
																																			// TODO: handle exception
																																			response.sendRedirect("page_404.jsp");
																																			e.printStackTrace();
																																		}
																																	}
																																	else
																																		if(request.getServletPath().equals("/VoyageParType")) {
																																			try {
																																				String mc=request.getParameter("Type");	
																																				System.out.println("MC : "+mc);
																																				
																																				List<String> Destination= voyagedao.listeVoyagDest();
																																				List<Circuit_accompagnes> circuitA=circuitdao.listeCircuit();
																																				List<Type_de_Voyage> vType=typedao.listeTypeVoyage();
																																				List<Voyage_a_themes> vThemes=themedao.listeTheme();
																																				List<Hebergement> hebergement=hebergementdao.listeHebergement();
																																				request.setAttribute("circuitA", circuitA);
																																				request.setAttribute("vType", vType);
																																				request.setAttribute("hebergement", hebergement);
																																				request.setAttribute("vThemes", vThemes);
																																				request.setAttribute("Destination", Destination);
																																				
																																				List<Voyage> lvoyage=voyagedao.listeVoyageParType(mc);
																																				request.setAttribute("lvoyage", lvoyage);
																																				System.out.println("chuf : "+lvoyage);
																																				request.getRequestDispatcher("AddVoyageAdmin.jsp").forward(request, response);
																																			}
																																			catch (Exception e) {
																																				// TODO: handle exception
																																				response.sendRedirect("page_404.jsp");
																																				e.printStackTrace();
																																			}
																																		}
																																		else
																																			if(request.getServletPath().equals("/VoyageCercuit")) {
																																				try {
																																					int idCircuit = Integer.parseInt(request.getParameter("idCircuit"));
																																					model.setIdCV(idCircuit);
																																					List<Voyage> lvoyage=voyagedao.listeVoyageParCircuit(idCircuit);
																																					List<Voyage> lvoyageex=voyagedao.listeVoyageParCircuitExpirer(idCircuit);
																																					System.out.println("chuf : "+lvoyage);
																																					System.out.println("chuf : "+lvoyageex);
																																					request.setAttribute("lvoyage", lvoyage);
																																					request.setAttribute("lvoyageex", lvoyageex);
																																					request.getRequestDispatcher("/voyageCercuit.jsp").forward(request, response);
																																				}
																																				catch(Exception e) {
																																					response.sendRedirect("page_404.jsp");
																																					e.printStackTrace();
																																				}
																																			}
																																			else
																																				if(request.getServletPath().equals("/pdfVoyageCercuit")) {
																																					try {
																																						response.setContentType("application/pdf");
																																						DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
																																						String currentDateTime = dateFormatter.format(new java.util.Date());
																																						String headerKey = "Content-Disposition";
																																						String headerValue = "attachment; filename=liste " + currentDateTime + ".pdf";
																																						response.setHeader(headerKey, headerValue);
																																						List<Voyage> lvoyage=voyagedao.listeVoyageParCircuit(model.getIdCV());
																																						CercuitVoyagePdf exporter = new CercuitVoyagePdf(lvoyage);
																																						exporter.export(response);
																																					}
																																					catch(Exception e) {
																																						response.sendRedirect("page_404.jsp");
																																						e.printStackTrace();
																																					}
																																				}
																																				else
																																					if(request.getServletPath().equals("/panierVoyage")) {
																																						try {
																																							int idClient = Integer.parseInt(request.getParameter("idClient"));
																																							//model.setIdCV(idCircuit);
																																							List<Voyage> lvoyage=clientsdao.Panier(idClient);
																																							List<Voyage> lvoyageN=clientsdao.PanierNon(idClient);
																																							System.out.println("chuf : "+lvoyage);
																																							System.out.println("chuf : "+lvoyageN);
																																							request.setAttribute("lvoyage", lvoyage);
																																							request.setAttribute("lvoyageN", lvoyageN);
																																							request.getRequestDispatcher("/panierVoyage.jsp").forward(request, response);
																																						}
																																						catch(Exception e) {
																																							response.sendRedirect("page_404.jsp");
																																							e.printStackTrace();
																																						}
																																					}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
