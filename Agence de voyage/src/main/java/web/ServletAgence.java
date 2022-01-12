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
import dao.ContactDaoImpl;
import dao.LoginAdminDao;
import dao.ThemeVoyageDaoImpl;
import dao.TypeVoyageDaoImpl;
import dao.VoyageDaoImpl;
import dao.HebergementDaoImpl;
import dao.ICircuitAccompDAO;
import dao.IClientDAO;

import dao.IHebergementDao;
import dao.IPanierDAO;
import dao.ITheme_de_VoyageDAO;
import dao.IType_de_VoyageDAO;

import dao.IVoyageDao;
import dao.ImpCircuitAccompDAO;
import dao.ImpClientDAO;
import dao.ImpHebergementDAO;
import dao.ImpPanierDAO;
import dao.ImpTheme_de_VoyageDAO;
import dao.ImpType_de_VoyageDAO;
import dao.ImpVoyageDAO;
import metier.Administrateur;
import metier.CercuitVoyagePdf;
import metier.CircuitPdf;
import metier.Circuit_accompagnes;
import metier.ClientParticipantPdf;
import metier.Clients;
import metier.Contact;
import metier.Hebergement;
import metier.Voyage_a_themes;
import metier.Type_de_Voyage;
import metier.Voyage;
import web.model;

/**
 * Servlet implementation class ServletAgence
 */
@WebServlet(urlPatterns = {"/ServletAgence","/loginAdmin","/logoutAdmin","/listClients","/ClientParMc","/AddNewheberg","/ListHeberg"
		,"/DeleteHeberg","/ListTheme","/AddNewTheme","/DeleteThemes","/ListType","/AddNewType","/DeleteType",
		"/ListCircuit","/AddCircuit","/DeleteCircuit","/Details_circuit","/PupdateCircuit","/updateCircuit"
		,"/pdfCircuit","/ListVoyage","/AddVoyage","/Details_voyage","/PupdateVoyage","/updateVoyage"
		,"/deleteVoyage","/listVoyageExpir","/detailsVoyageExpir","/deleteVoyageExpir","/VoyageParDate"
		,"/VoyageParDest","/VoyageParTheme","/VoyageParType","/VoyageCercuit","/pdfVoyageCercuit"
		,"/panierVoyage","/deleteClient","/listeParticipants","/PdfParticipants","/Home","/ShowMessage"
		,"/deleteMessage","/ListMessageNonVue","/MessageVue","/deleteMessageVue",



		"/logout","/login.php","/inscription.php","/listFormulaireDeRecherche",
		"/AllTrip","/RechercheParPlusieursMotsCles","/listFormulaireDeRecherche1","/AllTripVisiteur",
		"/AllTypeVoyage","/AllThemeVoyage","/AllHebergement","/ProfilClient","/ModifierClient","/updateClient",
		"/ClientInfo","/AllVoyageTypeVoyage","/AllVoyageTheme","/AllVoyagehebergement",
		"/AllDetailsTrip","/ajouterAuPanier","/VoyageDuPanier","/AllDetailsTripAfterAjout",
		"/AllDetailsTripPanier","/RejoindreVoyage","/AllDetailsTripapresRejoin",
		"/supprimerVPanier","/contact"
})
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
	private ContactDaoImpl contactdao;



	model md=new model();
	IClientDAO umetier = new ImpClientDAO();
	IType_de_VoyageDAO typevmetier = new ImpType_de_VoyageDAO(); 
	IVoyageDao vmetier = new ImpVoyageDAO();   
	ITheme_de_VoyageDAO themevmetier = new ImpTheme_de_VoyageDAO();
	IHebergementDao hebergvmetier = new ImpHebergementDAO();
	IClientDAO clientMetier = new ImpClientDAO();
	ICircuitAccompDAO circuitMetier = new ImpCircuitAccompDAO();
	IPanierDAO panierMetier = new ImpPanierDAO();

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
		contactdao=new ContactDaoImpl();
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
		String path= request.getServletPath();
		System.out.print("Path : " + request.getServletPath());
		System.out.println();

		// login admin 

		if(request.getServletPath().equals("/loginAdmin")) {
			try {
				String email_admin = request.getParameter("email_admin");
				String mdp_admin = request.getParameter("mdp_admin");
				System.out.println("email_admin :" + email_admin);
				System.out.println("mdp_admin :" + mdp_admin);
				Administrateur loginA= new Administrateur();
				loginA.setEmail_admin(email_admin);
				loginA.setMdp_admin(mdp_admin);


				if(loginAdmin.login(loginA)) {
					HttpSession session = request.getSession();
					System.out.println("session created");
					session.setAttribute("nom","Administrateur");
					System.out.println("session ok");
					request.getRequestDispatcher("/Home").forward(request, response);
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
								List<Hebergement> hebergementList=hebergementdao.listeHebergement();
								int res=1;
								for(int i=0;i<hebergementList.size();i++) {
									if(newHeberg.equalsIgnoreCase(hebergementList.get(i).getNom_heberg())) {
										res=2;
									}
								}
								if(res==1) {
									System.out.println("newHeberg :" + newHeberg);
									Hebergement hebergement=new Hebergement();
									hebergement.setNom_heberg(newHeberg);
									hebergementdao.addHebergement(hebergement);
									request.getRequestDispatcher("/ListHeberg").forward(request, response);
								}
								else {
									request.setAttribute("Name", "existe déjà");
									request.getRequestDispatcher("gestion_type_hebergement_Admin.jsp").forward(request, response);
								}
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
												List<Voyage_a_themes> vThemes=themedao.listeTheme();
												int res=1;
												for(int i=0;i<vThemes.size();i++) {
													if(newTheme.equalsIgnoreCase(vThemes.get(i).getNom_theme())) {
														res=2;
													}
												}
												if(res==2) {
													request.setAttribute("Name", "existe déjà");
													request.getRequestDispatcher("gestion_themes.jsp").forward(request, response);
												}
												else {
													System.out.println("newTheme :" + newTheme);
													Voyage_a_themes themes=new Voyage_a_themes();
													themes.setNom_theme(newTheme);
													themedao.addTheme(themes);
													request.getRequestDispatcher("/ListTheme").forward(request, response);
												}
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
															List<Type_de_Voyage> vType=typedao.listeTypeVoyage();
															int res=1;
															for(int i=0;i<vType.size();i++) {
																if(newType.equalsIgnoreCase(vType.get(i).getNom_typev())) {
																	res=2;
																}
															}
															if(res==2) {
																request.setAttribute("Name", "existe déjà");
																request.getRequestDispatcher("gestion_type_voyage.jsp").forward(request, response);
															}
															else {
																System.out.println("newTheme :" + newType);
																Type_de_Voyage type=new Type_de_Voyage();
																type.setNom_typev(newType);
																typedao.addTypeVoyage(type);
																request.getRequestDispatcher("/ListType").forward(request, response);
															}
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
																																					else
																																						if(request.getServletPath().equals("/deleteClient")){
																																							try {
																																								int idClient = Integer.parseInt(request.getParameter("idClient"));
																																								clientsdao.deleteClients(idClient);
																																								request.getRequestDispatcher("/listClients").forward(request, response);
																																							}
																																							catch(Exception e) {
																																								response.sendRedirect("page_404.jsp");
																																								e.printStackTrace();
																																							}
																																						}
																																						else
																																							if(request.getServletPath().equals("/listeParticipants")) {
																																								try {
																																									int idVoyage = Integer.parseInt(request.getParameter("idVoyage"));
																																									model.setPdfparti(idVoyage);
																																									Voyage voya=voyagedao.getVoyage(idVoyage);
																																									int a=voya.getNbrPlace();
																																									List<Clients> lClients= voyagedao.listeParticipants(idVoyage);
																																									request.setAttribute("lClients", lClients);
																																									if(a==0) {
																																										request.setAttribute("voya", "Liste complète");
																																									}
																																									else {
																																										request.setAttribute("voya", "Le nombre de places restantes : "+a);
																																									}
																																									request.getRequestDispatcher("/voyageParticipant.jsp").forward(request, response);
																																								}
																																								catch(Exception e) {
																																									response.sendRedirect("page_404.jsp");
																																									e.printStackTrace();
																																								}
																																							}
																																							else
																																								if(request.getServletPath().equals("/PdfParticipants")) {
																																									try {
																																										response.setContentType("application/pdf");
																																										DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
																																										String currentDateTime = dateFormatter.format(new java.util.Date());
																																										String headerKey = "Content-Disposition";
																																										String headerValue = "attachment; filename=Liste des participants" + currentDateTime + ".pdf";
																																										response.setHeader(headerKey, headerValue);
																																										List<Clients> lClients= voyagedao.listeParticipants(model.getPdfparti());
																																										ClientParticipantPdf exporter= new ClientParticipantPdf(lClients);
																																										exporter.export(response);
																																									}
																																									catch(Exception e) {
																																										response.sendRedirect("page_404.jsp");
																																										e.printStackTrace();
																																									}
																																								}
																																								else
																																									if(request.getServletPath().equals("/Home")){
																																										try {
																																											int nbrClient=voyagedao.nbrClient();
																																											int nbrVoyage=voyagedao.nbrVoyage();
																																											int nbrCircuit=voyagedao.nbrCircuit();
																																											int nbrTheme=voyagedao.nbrTheme();
																																											int nbrType=voyagedao.nbrType();
																																											int nbrHeberg=voyagedao.nbrHeberg();
																																											int message =contactdao.nbrMessage();
																																											request.setAttribute("nbrClient", nbrClient);
																																											request.setAttribute("nbrVoyage", nbrVoyage);
																																											request.setAttribute("nbrCircuit", nbrCircuit);
																																											request.setAttribute("nbrTheme", nbrTheme);
																																											request.setAttribute("nbrType", nbrType);
																																											request.setAttribute("nbrHeberg", nbrHeberg);
																																											request.setAttribute("message", message);
																																											System.out
																																											.println(message);
																																											List<Contact> Lcontacl= contactdao.Nonvue();
																																											System.out
																																											.println(Lcontacl);
																																											request.setAttribute("Lcontacl", Lcontacl);
																																											request.getRequestDispatcher("/indexAdmin.jsp").forward(request, response);
																																										}
																																										catch(Exception e) {
																																											response.sendRedirect("page_404.jsp");
																																											e.printStackTrace();
																																										}
																																									}
																																									else
																																										if(request.getServletPath().equals("/ShowMessage")) {
																																											try {
																																												int idMessage = Integer.parseInt(request.getParameter("idMessage"));
																																												Contact conta=contactdao.getMessage(idMessage);
																																												contactdao.setVue(idMessage);
																																												request.setAttribute("conta", conta);
																																												request.getRequestDispatcher("/showMessage.jsp").forward(request, response);

																																											}
																																											catch(Exception e) {
																																												response.sendRedirect("page_404.jsp");
																																												e.printStackTrace();
																																											}
																																										}
																																										else
																																											if(request.getServletPath().equals("/deleteMessage")) {
																																												try {
																																													int idMessage = Integer.parseInt(request.getParameter("idMessage"));
																																													contactdao.removeMessage(idMessage);
																																													request.getRequestDispatcher("/ListMessageNonVue").forward(request, response);

																																												}
																																												catch(Exception e) {
																																													response.sendRedirect("page_404.jsp");
																																													e.printStackTrace();
																																												}
																																											}
																																											else
																																												if(request.getServletPath().equals("/ListMessageNonVue")) {
																																													try {
																																														List<Contact> contact=contactdao.Nonvue();
																																														request.setAttribute("contact", contact);
																																														request.getRequestDispatcher("/messageNonVue.jsp").forward(request, response);
																																													}
																																													catch(Exception e) {
																																														response.sendRedirect("page_404.jsp");
																																														e.printStackTrace();
																																													}
																																												}
																																												else
																																													if(request.getServletPath().equals("/MessageVue")) {
																																														try {
																																															List<Contact> contact=contactdao.Vue();
																																															request.setAttribute("contact", contact);
																																															request.getRequestDispatcher("/messageVue.jsp").forward(request, response);
																																														}
																																														catch(Exception e) {
																																															response.sendRedirect("page_404.jsp");
																																															e.printStackTrace();
																																														}
																																													}
																																													else
																																														if(request.getServletPath().equals("/deleteMessageVue")) {
																																															try {
																																																int idMessage = Integer.parseInt(request.getParameter("idMessage"));
																																																contactdao.removeMessage(idMessage);
																																																request.getRequestDispatcher("/MessageVue").forward(request, response);

																																															}
																																															catch(Exception e) {
																																																response.sendRedirect("page_404.jsp");
																																																e.printStackTrace();
																																															}
																																														}



																																															///////////////////



																																														else
																																															if(path.equals("/logout")) {
																																																HttpSession session =request.getSession(); 
																																																session.removeAttribute("client");
																																																session.invalidate();
																																																//response.sendRedirect("/Agence de voyage/listFormulaireDeRecherche1");
																																																request.getRequestDispatcher("/listFormulaireDeRecherche1").forward(request, response);


																																															}
																																															else

																																																//////////-----------------------------------------LOGIN--------------------------------------------------------------------------////		


																																																if (path.equals("/login.php")) {
																																																	System.out.println(4);
																																																	String email = request.getParameter("email");
																																																	String mdp = request.getParameter("mdp");
																																																	System.out.println(email+ "-" +mdp);
																																																	if(umetier.login(email, mdp)){
																																																		HttpSession session =request.getSession();
																																																		System.out.println("session created");

																																																		session.setAttribute("client", umetier.getClients(email,mdp));



																																																		Clients u = umetier.getClients(email, mdp);

																																																		session.setAttribute("Nom", u.getNom_client());
																																																		session.setAttribute("Prénom", u.getPrenom_client());
																																																		md.setIdSession(u.getId_client());

																																																		System.out.println("C'est l id client "+(u.getId_client()));
																																																		//response.sendRedirect("/Agence de voyage/listFormulaireDeRecherche");
																																																		request.getRequestDispatcher("/listFormulaireDeRecherche").forward(request, response);

																																																	}
																																																	else {
																																																		HttpSession session =request.getSession(); 
																																																		session.setAttribute("client", null);
																																																		int testA = 1 ; 
																																																		String erreurA = "Mot de passe ou nom d'utilisateur incorrect ! ";
																																																		session.setAttribute("testA", testA);
																																																		session.setAttribute("eA", erreurA);
																																																		request.setAttribute("eA", erreurA);
																																																		System.out.println(erreurA);
																																																		request.getRequestDispatcher("/Login.jsp").forward(request, response);

																																																	}

																																																}


		//////////-------------------------------------Register--------------------------------------------------------------------------////		

																																																else
																																																	if(path.equals("/inscription.php"))
																																																	{	
																																																		String registernom = request.getParameter("registernom");
																																																		String registerprenom = request.getParameter("registerprenom");
																																																		String registerEmail = request.getParameter("registerEmail");
																																																		String registerPassword = request.getParameter("registerPassword");
																																																		String registerPhone = request.getParameter("registerphone");

																																																		Clients cl = new Clients();

																																																		cl.setNom_client(registernom);
																																																		cl.setPrenom_client(registerprenom);
																																																		cl.setEmail_client(registerEmail);
																																																		cl.setMdp_client(registerPassword);
																																																		cl.setTel_client(registerPhone);
																																																		System.out.println("path : " + path);



																																																		umetier.Inscription(cl);
																																																		System.out.println("inscription Done !");
																																																		this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);


																																																	}

																																																	else
																																																		if (path.equals("/listFormulaireDeRecherche"))
																																																		{ 

																																																			request.setAttribute("Type_de_Voyage", typevmetier.liste_Type_de_Voyage1());
																																																			request.setAttribute("Destination", vmetier.liste_Voyage());
																																																			System.out.println("la destination est listée");
																																																			request.setAttribute("duree", vmetier.liste_Voyage());
																																																			System.out.println("la durée est listée");
																																																			request.setAttribute("Voyage", vmetier.liste_Voyage());
																																																			System.out.println(vmetier.liste_Voyage());
																																																			System.out.println("ewa hade bayna");

																																																			request.getRequestDispatcher("/index.jsp").forward(request, response); 

																																																		}
																																																		else
																																																			if (path.equals("/listFormulaireDeRecherche1"))
																																																			{ 
																																																				try {
																																																					request.setAttribute("Type_de_Voyage", typevmetier.liste_Type_de_Voyage());
																																																					request.setAttribute("Destination", vmetier.liste_Voyage());
																																																					System.out.println("la destination est listée");
																																																					request.setAttribute("duree", vmetier.liste_Voyage());
																																																					System.out.println("la durée est listée");
																																																					request.setAttribute("Voyage", vmetier.liste_Voyage());
																																																					System.out.println(vmetier.liste_Voyage());
																																																					System.out.println("chuf");

																																																					request.getRequestDispatcher("/indexvisit.jsp").forward(request, response); 
																																																				}
																																																				catch(Exception e) {
																																																					response.sendRedirect("404.jsp");
																																																					e.printStackTrace();
																																																				}

																																																			}
																																																			else
																																																				if (path.equals("/AllTrip"))
																																																				{ 
																																																					request.setAttribute("Voyage", vmetier.liste_Voyage());
																																																					System.out.println("la destination est listée");
																																																					System.out.println("la durée est listée");
																																																					System.out.println(vmetier.liste_Voyage());

																																																					request.getRequestDispatcher("/menu.jsp").forward(request, response); 

																																																				}


																																																				else

																																																					if (path.equals("/RechercheParPlusieursMotsCles")) {

																																																						String destination = request.getParameter("destination");
																																																						String duree = request.getParameter("duree");
																																																						System.out.println(1);
																																																						String budget = request.getParameter("budget");
																																																						System.out.println(2);
																																																						Date date  = Date.valueOf(request.getParameter("date"));
																																																						System.out.println(request.getParameter("date"));
																																																						System.out.println(3);
																																																						System.out.println("chuf : " +request.getParameter("Type"));
																																																						//System.out.println("dd :"+request.getParameter("Type").);

																																																						String fk_idtypev = request.getParameter("Type");
																																																						System.out.println("ayih : "+fk_idtypev);

																																																						//md.setCpt_id_typev(fk_idtypev);
																																																						Voyage cl = new Voyage();
																																																						cl.setDestination(destination);
																																																						cl.setDuree(duree);
																																																						//cl.setBudget(budget);
																																																						cl.setDate_depart(date);
																																																						//cl.setFk_id_typev(fk_idtypev);
																																																						//typevmetier.ObtenirNomTypeV(md.getCpt_id_typev())

																																																						System.out.println(cl);
																																																						List<Voyage> voyage_Chercher=vmetier.chercherVoyage(cl,budget,fk_idtypev);
																																																						System.out.println("list : "+voyage_Chercher);
																																																						System.out.println("gg : "+voyage_Chercher.isEmpty());
																																																						if (voyage_Chercher.isEmpty()==true) {
																																																							request.setAttribute("VoyageNot", "No trips with your choices");
																																																						}
																																																						else {
																																																							request.setAttribute("Voyage", voyage_Chercher);
																																																						}
																																																						request.getRequestDispatcher("/index.jsp").forward(request, response);


																																																					}
																																																					else
																																																						if (path.equals("/AllTripVisiteur"))
																																																						{ 
																																																							request.setAttribute("Voyage", vmetier.liste_Voyage());
																																																							System.out.println("la destination est listée");
																																																							System.out.println("la durée est listée");
																																																							System.out.println(vmetier.liste_Voyage());
																																																							request.setAttribute("Type_de_Voyage", typevmetier.liste_Type_de_Voyage());
																																																							request.setAttribute("Destination", vmetier.liste_Voyage());
																																																							System.out.println("la destination est listée");
																																																							request.setAttribute("duree", vmetier.liste_Voyage());
																																																							System.out.println("la durée est listée");
																																																							request.setAttribute("Voyage", vmetier.liste_Voyage());
																																																							System.out.println(vmetier.liste_Voyage());
																																																							System.out.println("chuf");

																																																							request.getRequestDispatcher("/menuVisiteur.jsp").forward(request, response); 

																																																						}
																																																						else
																																																							if (path.equals("/AllTypeVoyage"))
																																																							{ 
																																																								request.setAttribute("TypeVoyage", typevmetier.liste_Type_de_Voyage());
																																																								System.out.println("type est listé");
																																																								request.getRequestDispatcher("/TypeVoyage.jsp").forward(request, response); 

																																																							}

																																																							else
																																																								if (path.equals("/AllThemeVoyage"))
																																																								{ 
																																																									request.setAttribute("ThemeVoyage", themevmetier.list_Themes_de_Voyage());
																																																									System.out.println("theme est listé");
																																																									request.getRequestDispatcher("/ThemeVoyage.jsp").forward(request, response); 

																																																								}
																																																								else
																																																									if (path.equals("/AllHebergement"))
																																																									{ 
																																																										request.setAttribute("Hebergement", hebergvmetier.list_Hebergement());
																																																										System.out.println("theme est listé");
																																																										request.getRequestDispatcher("/Hebergement.jsp").forward(request, response); 

																																																									}
																																																									else
																																																										if(path.equals("/ProfilClient"))
																																																										{
																																																											int idclient = Integer.parseInt(request.getParameter("idClient"));
																																																											md.setCptUser(idclient);

																																																											request.setAttribute("ad", clientMetier.getClient(idclient));
																																																											request.setAttribute("Voyage", vmetier.liste_VoyageConfirmer(idclient));
																																																											System.out.println(clientMetier.getClient(idclient));
																																																											System.out.println("profil affiché");
																																																											request.getRequestDispatcher("/ProfilClient.jsp").forward(request, response);

																																																										}

																																																										else
																																																											if (request.getServletPath().equals("/updateClient")) {

																																																												List<Clients> cl =clientMetier.getClient(md.getIdSession());

																																																												System.out.println("idUser :"+md.getCptUser());

																																																												request.setAttribute("cl",cl);
																																																												request.getRequestDispatcher("/ModifierClient.jsp").forward(request, response);
																																																											}



																																																											else
																																																												if(request.getServletPath().equals("/ModifierClient")){
																																																													Clients u = new Clients();
																																																													System.out.println(400);
																																																													System.out.println(request.getParameter("nom"));
																																																													u.setNom_client(request.getParameter("nom"));
																																																													u.setPrenom_client(request.getParameter("prenom"));
																																																													u.setEmail_client(request.getParameter("email"));
																																																													u.setTel_client(request.getParameter("tel"));
																																																													System.out.println(md.getCptUser());
																																																													umetier.modifierClientProfil(md.getIdSession(),u);
																																																													request.getRequestDispatcher("/ClientInfo").forward(request, response);

																																																												}
																																																												else
																																																													if (path.equals("/ClientInfo"))
																																																													{ 
																																																														request.setAttribute("ad", clientMetier.getClient(md.getIdSession()));
																																																														System.out.println(900);

																																																														this.getServletContext().getRequestDispatcher("/ProfilClient.jsp").forward(request, response);

																																																													}

																																																													else
																																																														if (path.equals("/AllVoyageTypeVoyage"))
																																																														{ 

																																																															int idType = Integer.parseInt(request.getParameter("IdType"));
																																																															md.setCptTypev(idType);

																																																															request.setAttribute("TypeVoyage", vmetier.liste_Voyage_TypeVoyage(idType));
																																																															if (vmetier.liste_Voyage_TypeVoyage(idType).isEmpty()==true) {
																																																																request.setAttribute("VoyagenotExist", "pas de Voyage pour ce type ! ");
																																																															}
																																																															System.out.println(vmetier.liste_Voyage_TypeVoyage(idType));
																																																															System.out.println("type est listé");

																																																															request.getRequestDispatcher("/VoyageTypeV.jsp").forward(request, response); 

																																																														}

																																																														else
																																																															if (path.equals("/AllVoyageTheme"))
																																																															{ 

																																																																int idTheme = Integer.parseInt(request.getParameter("IdTheme"));
																																																																md.setCptThemev(idTheme);

																																																																if (vmetier.liste_Voyage_Theme(idTheme).isEmpty()==true) {
																																																																	request.setAttribute("VoyagenotExist1", "pas de Voyage pour ce theme ! ");
																																																																}
																																																																else {
																																																																	request.setAttribute("TypeVoyage", vmetier.liste_Voyage_Theme(idTheme));
																																																																	System.out.println(vmetier.liste_Voyage_Theme(idTheme));
																																																																	System.out.println("theme est listé");
																																																																}


																																																																request.getRequestDispatcher("/VoyageThemev.jsp").forward(request, response); 

																																																															}


																																																															else
																																																																if (path.equals("/AllVoyagehebergement"))
																																																																{  
																																																																	int IdHeber = Integer.parseInt(request.getParameter("IdHeber"));
																																																																	md.setCptheber(IdHeber);

																																																																	if (vmetier.liste_Voyage_Hebergement(IdHeber).isEmpty()==true) {
																																																																		request.setAttribute("VoyagenotExist3", "pas de Voyage pour cet hebergement ! ");
																																																																	}
																																																																	else {
																																																																		request.setAttribute("TypeVoyage", vmetier.liste_Voyage_Hebergement(IdHeber));
																																																																		System.out.println(vmetier.liste_Voyage_Hebergement(IdHeber));
																																																																		System.out.println("hebergement est listé");
																																																																	}

																																																																	request.getRequestDispatcher("/VoyageHebergement.jsp").forward(request, response); 

																																																																}

																																																																else
																																																																	if (path.equals("/AllDetailsTrip"))
																																																																	{ 
																																																																		int Id_Voyage = Integer.parseInt(request.getParameter("Id_Voyage"));
																																																																		md.setCptidv(Id_Voyage);
																																																																		request.setAttribute("Voyage", vmetier.liste_Voyage(Id_Voyage));
																																																																		System.out.println("ana huna");
																																																																		System.out.println(vmetier.liste_Voyage(Id_Voyage));
																																																																		request.setAttribute("NomType", typevmetier);
																																																																		request.setAttribute("NomTheme", themevmetier);
																																																																		request.setAttribute("NomHeber", hebergvmetier);
																																																																		request.setAttribute("NomCircuit", circuitMetier);

																																																																		switch(typevmetier.ObtenirNomTypeV(vmetier.getVoyage(Id_Voyage).getFk_id_typev()))
																																																																		{

																																																																		case "en couple":
																																																																			request.setAttribute("Remarque", "*Vous Pouvez emmener un binôme");
																																																																			break;
																																																																		case "en groupe":
																																																																			request.setAttribute("Remarque", "*Vous Pouvez emmener un ensemble de personne");
																																																																			break;
																																																																		case "en famille":
																																																																			request.setAttribute("Remarque", "*Vous Pouvez emmener votre famille");
																																																																			break;
																																																																		case "individuel":
																																																																			request.setAttribute("Remarque", "*Vous Venez Seul");
																																																																			break;
																																																																		default:
																																																																			request.setAttribute("Remarque", "*C'est ouvert pour n'importe quel nombre de personne vous apportez");

																																																																		}
																																																																		request.getRequestDispatcher("/DetailsVoyage.jsp").forward(request, response); 

																																																																	}


																																																																	else 
																																																																		if (path.equals("/VoyageDuPanier")) {
																																																																			request.setAttribute("Voyage",vmetier.liste_VoyagePanier(md.getIdSession()));
																																																																			System.out.println(5);
																																																																			this.getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);
																																																																		}

																																																																		else 
																																																																			if (path.equals("/ajouterAuPanier")) {


																																																																				int Id_Voyage = Integer.parseInt(request.getParameter("Id_Voyage"));
																																																																				System.out.println(Id_Voyage);
																																																																				System.out.println( md.getCptUser());
																																																																				panierMetier.ajouterVAuPanier(md.getIdSession(),Id_Voyage);

																																																																				System.out.println(5);

																																																																				//response.sendRedirect("/Agence de voyage/VoyageDuPanier");
																																																																				request.getRequestDispatcher("/VoyageDuPanier").forward(request, response);
																																																																			}


																																																																			else
																																																																				if (path.equals("/AllDetailsTripAfterAjout"))
																																																																				{ 
																																																																					int Id_Voyage = Integer.parseInt(request.getParameter("Id_Voyage"));
																																																																					md.setCptidv(Id_Voyage);
																																																																					request.setAttribute("Voyage", vmetier.liste_Voyage(Id_Voyage));
																																																																					System.out.println("ana huna");
																																																																					System.out.println(vmetier.liste_Voyage(Id_Voyage));
																																																																					request.setAttribute("NomType", typevmetier);
																																																																					request.setAttribute("NomTheme", themevmetier);
																																																																					request.setAttribute("NomHeber", hebergvmetier);
																																																																					request.setAttribute("NomCircuit", circuitMetier);

																																																																					switch(typevmetier.ObtenirNomTypeV(vmetier.getVoyage(Id_Voyage).getFk_id_typev()))
																																																																					{

																																																																					case "en couple":
																																																																						request.setAttribute("Remarque", "*Vous Pouvez emmener un binôme");
																																																																						break;
																																																																					case "en groupe":
																																																																						request.setAttribute("Remarque", "*Vous Pouvez emmener maximum 5 personnes");
																																																																						break;
																																																																					case "en famille":
																																																																						request.setAttribute("Remarque", "*Vous Pouvez emmener votre famille maximum 4 personnes");
																																																																						break;
																																																																					case "individuel":
																																																																						request.setAttribute("Remarque", "*Vous Venez Seul");
																																																																						break;
																																																																					default:
																																																																						request.setAttribute("Remarque", "*C'est ouvert pour n'importe quel nombre de personne vous apportez");

																																																																					}
																																																																					request.getRequestDispatcher("/DetailsVoyageApresAjout.jsp").forward(request, response); 

																																																																				}
																																																																				else
																																																																					if (path.equals("/AllDetailsTripPanier"))
																																																																					{ 
																																																																						int Id_Voyage = Integer.parseInt(request.getParameter("Id_Voyage"));
																																																																						md.setCptidv(Id_Voyage);
																																																																						request.setAttribute("Voyage", vmetier.liste_Voyage(Id_Voyage));
																																																																						System.out.println("ana huna");
																																																																						System.out.println(vmetier.liste_Voyage(Id_Voyage));
																																																																						request.setAttribute("NomType", typevmetier);
																																																																						request.setAttribute("NomTheme", themevmetier);
																																																																						request.setAttribute("NomHeber", hebergvmetier);
																																																																						request.setAttribute("NomCircuit", circuitMetier);

																																																																						switch(typevmetier.ObtenirNomTypeV(vmetier.getVoyage(Id_Voyage).getFk_id_typev()))
																																																																						{

																																																																						case "en couple":
																																																																							request.setAttribute("Remarque", "*Vous Pouvez emmener un binôme");
																																																																							break;
																																																																						case "en groupe":
																																																																							request.setAttribute("Remarque", "*Vous Pouvez emmener maximum 5 personnes");
																																																																							break;
																																																																						case "en famille":
																																																																							request.setAttribute("Remarque", "*Vous Pouvez emmener votre famille maximum 4 personnes");
																																																																							break;
																																																																						case "individuel":
																																																																							request.setAttribute("Remarque", "*Vous Venez Seul");
																																																																							break;
																																																																						default:
																																																																							request.setAttribute("Remarque", "*C'est ouvert pour n'importe quel nombre de personne vous apportez");

																																																																						}
																																																																						request.getRequestDispatcher("/DetailsVoyagePanier.jsp").forward(request, response); 

																																																																					}
																																																																					else 
																																																																						if (path.equals("/RejoindreVoyage")) {


																																																																							int Id_Voyage = Integer.parseInt(request.getParameter("Id_Voyage"));
																																																																							System.out.println("id voyage"+Id_Voyage);
																																																																							System.out.println("id user"+ md.getCptUser());
																																																																							vmetier.rejoindreVoyage(md.getIdSession(),Id_Voyage);

																																																																							//System.out.println(5);

																																																																							//response.sendRedirect("/Agence de voyage/ProfilClient");
																																																																							request.getRequestDispatcher("/ProfilClient").forward(request, response);
																																																																						}
																																																																						else
																																																																							if (path.equals("/AllDetailsTripapresRejoin"))
																																																																							{ 
																																																																								int Id_Voyage = Integer.parseInt(request.getParameter("Id_Voyage"));
																																																																								md.setCptidv(Id_Voyage);
																																																																								request.setAttribute("Voyage", vmetier.liste_Voyage(Id_Voyage));
																																																																								System.out.println("ana huna");
																																																																								System.out.println(vmetier.liste_Voyage(Id_Voyage));
																																																																								request.setAttribute("NomType", typevmetier);
																																																																								request.setAttribute("NomTheme", themevmetier);
																																																																								request.setAttribute("NomHeber", hebergvmetier);
																																																																								request.setAttribute("NomCircuit", circuitMetier);

																																																																								switch(typevmetier.ObtenirNomTypeV(vmetier.getVoyage(Id_Voyage).getFk_id_typev()))
																																																																								{

																																																																								case "en couple":
																																																																									request.setAttribute("Remarque", "*Vous Pouvez emmener un binôme");
																																																																									break;
																																																																								case "en groupe":
																																																																									request.setAttribute("Remarque", "*Vous Pouvez emmener maximum 5 personnes");
																																																																									break;
																																																																								case "en famille":
																																																																									request.setAttribute("Remarque", "*Vous Pouvez emmener votre famille maximum 4 personnes");
																																																																									break;
																																																																								case "individuel":
																																																																									request.setAttribute("Remarque", "*Vous Venez Seul");
																																																																									break;
																																																																								default:
																																																																									request.setAttribute("Remarque", "*C'est ouvert pour n'importe quel nombre de personne vous apportez");

																																																																								}
																																																																								request.getRequestDispatcher("/DetailsVoyageApresRejoint.jsp").forward(request, response); 

																																																																							}
																																																																							else
																																																																								if (path.equals("/supprimerVPanier")) {
																																																																									int Id_Voyage = Integer.parseInt(request.getParameter("Id_Voyage"));
																																																																									panierMetier.SupprimerDuPanier(md.getIdSession(),Id_Voyage);
																																																																									request.setAttribute("i", 1);
																																																																									this.getServletContext().getRequestDispatcher("/PanierClient.jsp").forward(request, response);
																																																																								}
																																																																								else
																																																																									if(path.equals("/contact")) {
																																																																										try {
																																																																											String name= request.getParameter("name");
																																																																											String Laname= request.getParameter("Laname");
																																																																											String email= request.getParameter("email");
																																																																											String message= request.getParameter("message");
																																																																											umetier.Contact(name, Laname, email, message);
																																																																											request.setAttribute("message", "your message has been sent");
																																																																											request.getRequestDispatcher("/contact.jsp").forward(request, response);

																																																																										}
																																																																										catch (Exception e) {
																																																																											// TODO: handle exception
																																																																											e.printStackTrace();
																																																																										}

																																																																									}






























	}

}
