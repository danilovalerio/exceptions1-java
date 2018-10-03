package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import model.entidades.Reservar;
import model.exceptions.DomainException;

/**
 * Fazer um programa para ler os dados de uma reserva de hotel (n�mero do quarto, data
de entrada e data de sa�da) e mostrar os dados da reserva, inclusive sua dura��o em
dias. Em seguida, ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. 
O programa n�o deve aceitar dados inv�lidos para a reserva, conforme as seguintes regras:
- Altera��es de reserva s� podem ocorrer para datas futuras
- A data de sa�da deve ser maior que a data de entrada
 * 
 * @author Danilo
 *
 */

public class Programa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		try {
			
			Date dataCheckin = new Date();
			Date dataCheckout = new Date();
			
			System.out.println("----- PENS�O DO NANATO - SEJA BEM VINDO ------");
			System.out.print("Informe os dados abaixo: \n N�mero do quarto:");
			Integer numQuarto = sc.nextInt();
			
			System.out.print(" Data do checkin-In (DD/MM/ANO):");
			dataCheckin = sdf.parse(sc.next());
			System.out.print(" Data do check-Out (DD/MM/ANO):");
			dataCheckout = sdf.parse(sc.next());
			
		
			Reservar reser = new Reservar(numQuarto, dataCheckin, dataCheckout);
			System.out.println(reser.toString());
			
			//atualiza��o de datas
			System.out.print(" Data do checkin-In (DD/MM/ANO):");
			dataCheckin = sdf.parse(sc.next());
			
			System.out.print(" Data do check-Out (DD/MM/ANO):");
			dataCheckout = sdf.parse(sc.next());
			
			reser.atualizarDatas(dataCheckin, dataCheckout);
			System.out.println(reser.toString());
			
		}
		catch (ParseException e) {
			System.out.println("Formato de data inv�lido!");
		}
		catch (DomainException e) {
			System.out.println("Erro ao efetuar reserva: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro n�o esperado, contate o administrador.");
		}
		/*catch (IllegalArgumentException e) { //captura a excess�o ocorrida no atualizar
			System.out.println("Erro ao efetuar reserva: "+ e.getMessage());
		}*/
				
		sc.close();

	}

}
