package demenagement;
import java.util.*;

public class Algorythme {
public static void main(String[] args)  {
	int quantite_ancien_local = 34;
	int quantite_nouveau_local = 0;
	int nouveau_local_caisse_10_11kg = 0;
	int nouveau_local_caisse_11_13kg = 0;
	int nouveau_local_caisse_13_15kg = 0;
	int nouveau_local_caisse_15kg = 0;
	int caisses_en_transport = 0;
	int caisses_en_transport_camion1 = 0;
	int caisses_en_transport_camion2 = 0;
	int caisses_max_transport = 14;
	int caisses_max_camion1 = 9;
	int caisses_max_camion2 = 5;
	int numero_de_caisse_chargement = 0;
	int numero_de_caisse_dechargement = 0;
	float poids_total_chargement = 0;
	float poids_max_transport = 225;
	float prevision_poids = 0;
	float[] poidscaisse = new float [34];
	for(int index=0; index<poidscaisse.length; index++)
	{
		poidscaisse[index]= (Math.random(10, 20));
		System.out.print(poidscaisse[index] + " // ");
	}
	while (quantite_ancien_local > 0)
	{
		System.out.println(quantite_ancien_local + " ");
		while (caisses_en_transport < caisses_max_transport && quantite_ancien_local > 0 && prevision_poids < poids_max_transport )
		{
			poids_total_chargement = poidscaisse[numero_de_caisse_chargement] + poids_total_chargement;
			System.out.println(poids_total_chargement + " // ");
			numero_de_caisse_chargement++;
			quantite_ancien_local--;
			caisses_en_transport++;
			if (caisses_en_transport < caisses_max_camion1)
			{
				caisses_en_transport_camion1++;
			}
			else
			{
				caisses_en_transport_camion2++;
			}
			if (quantite_ancien_local > 0)
			{
				prevision_poids= poids_total_chargement + poidscaisse[numero_de_caisse_chargement];
			}
		}
		prevision_poids = 0;
		System.out.print("|Un voyage de " + caisses_en_transport + " cartons.|" + " |" + caisses_en_transport_camion1 + " dans le camion 1 et " + caisses_en_transport_camion2 + " dans le camion 2 |");
		while (caisses_en_transport > 0)
		{
			if (poidscaisse[numero_de_caisse_dechargement] <= 11)
			{
				nouveau_local_caisse_10_11kg++;
			}
			else if (poidscaisse[numero_de_caisse_dechargement] <= 13)
			{
				nouveau_local_caisse_11_13kg++;
			}
			else if (poidscaisse[numero_de_caisse_dechargement] <= 15)
			{
				nouveau_local_caisse_13_15kg++;
			}
			else
			{
				nouveau_local_caisse_15kg++;
			}
			quantite_nouveau_local++;
			caisses_en_transport--;
			caisses_en_transport_camion1 = 0;
			caisses_en_transport_camion2 = 0;
			poids_total_chargement = 0;
			numero_de_caisse_dechargement++;
		}
		System.out.println(quantite_nouveau_local + " // "+ nouveau_local_caisse_10_11kg + " // "+ nouveau_local_caisse_11_13kg + " // "+ nouveau_local_caisse_13_15kg + " // " + nouveau_local_caisse_15kg);
	}
}
}
