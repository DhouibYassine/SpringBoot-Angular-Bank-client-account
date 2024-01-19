package tn.iit.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "t_account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rib;
	private float balance;
	@Column(name = "client", length = 50)
	private String clientName;
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;
	public Account(float balance, String clientName) {
		super();
		this.balance = balance;
		this.clientName = clientName;
	}
}
