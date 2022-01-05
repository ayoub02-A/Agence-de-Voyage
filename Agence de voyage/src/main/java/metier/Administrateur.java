package metier;

import java.io.Serializable;

public class Administrateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		private String email_admin;
		private String mdp_admin;
		
		public Administrateur(){
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Administrateur(String email_admin,String mdp_admin) {
			this.email_admin = email_admin;
			this.mdp_admin = mdp_admin;
		}

		public String getEmail_admin() {
			return email_admin;
		}

		public void setEmail_admin(String email_admin) {
			this.email_admin = email_admin;
		}

		public String getMdp_admin() {
			return mdp_admin;
		}

		public void setMdp_admin(String mdp_admin) {
			this.mdp_admin = mdp_admin;
		}

		@Override
		public String toString() {
			return "administrateur [email_admin=" + email_admin + ", mdp_admin=" + mdp_admin + "]";
		}
		
}
