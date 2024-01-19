package tn.iit.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.EqualsAndHashCode.Include;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "t_client")
public class Client implements Serializable/* obligatoire selon la spec JEE */ {
	private static final long serialVersionUID = 1L;
	@Include
	@Id // PK
	@Column(length = 10)
	private String cin;
	private String nom;
	private String prenom;
	@ToString.Exclude // brake toString loop
	@JsonIgnore // brake JSON loop
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Account> comptes;
	//defautl fetch --> LAZY

	public Client(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}

}