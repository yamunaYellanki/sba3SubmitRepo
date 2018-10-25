package com.verizon.adb.model;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Packages")
public class Packages {
	
		@Id
		@Column(name="Title")
		@NotNull
		private String title;
		
		
		@Column(name="Net")
		@NotNull
		private int net;
		
		@Column(name="Maxusage")
		@NotNull
		private int maxusage;
		
		@Column(name="Cost")
		@NotNull
		private int cost;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getNet() {
			return net;
		}

		public void setNet(int net) {
			this.net = net;
		}

		public int getMaxusage() {
			return maxusage;
		}

		public void setMaxusage(int maxusage) {
			this.maxusage = maxusage;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public Packages() {
			
		}

		public Packages(@NotNull String title, @NotNull int net, @NotNull int maxusage, @NotNull int cost) {
			
			this.title = title;
			this.net = net;
			this.maxusage = maxusage;
			this.cost = cost;
		}

		
		
		
	}
		
