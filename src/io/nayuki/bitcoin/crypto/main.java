package io.nayuki.bitcoin.crypto;
import java.util.Arrays;

public final class main{
	
	public static void main(String[] args) {
		System.out.println("Let's start working on ECDSA....!");
		String pubKeyHex = "fbda4fdb246fe3bb3f8869482735580f90a24bf8020d819b540dfa991a510414";
//		int publicKey [] = toUint256(pubKeyHex);
//		Sha256Hash msgHash = new Sha256Hash("7F83B1657FF1FC53B92DC18148A1D65DFC2D4B1FA3D677284ADDD200126D9069");
		
		
//		int [] r = {54,222,232,137,83,236,44,138,108,208,180,134,55,70,217,203,184,102,51,63,22,207,247,156,236,14,41,79,49,212,249,7};
//		int [] s = {106,83,177,213,44,26,165,11,36,32,155,44,117,185,7,87,44,162,175,158,27,203,247,135,210,174,216,133,203,170,91,139};	
		
		
		String[][] testCase = {{"0", "77D9ECB1D22A45C107EE36FC6D62A4D32BAB6689A50F0FAE587E0B95A795E833", "9BB5CF3051C7FCD5B69CB80A59B052D75BB6C6090B28C1E5AC0C6502B04BE63B", "EF54D03E7453CED1A0A9529ADFBE46CE7440E40E3457CA1C040B6CAC9E3209E4", "EB4E0C2C1723EFE8192F2F8743D343F45B5B8A9A12012EE71743247B0F65DAD8", "08F4E06799E5919F72EE39D3473EB473BD8ADC672694D895734E8AE4D049E038"}};
		
		
		int[] publicKey = new int[CurvePointMath.POINT_WORDS];
		Int256Math.hexToUint(testCase[0][1], publicKey, CurvePointMath.XCOORD);
		Int256Math.hexToUint(testCase[0][2], publicKey, CurvePointMath.YCOORD);
		System.arraycopy(Int256Math.ONE, 0, publicKey, CurvePointMath.ZCOORD, Int256Math.NUM_WORDS);
		
		Sha256Hash msgHash = new Sha256Hash(testCase[0][3]);
		
		System.out.println("r  = " +  testCase[0][4]);
		System.out.println("s  = " +  testCase[0][5]);
		
		int[] r = toUint256(testCase[0][4]);
		int[] s = toUint256(testCase[0][5]);
		boolean isValid = Ecdsa.verify(publicKey, msgHash, r, s);
		System.out.println("Result" + isValid);
		
		

	}
	
	private static int[] toUint256(String hex) {
		int[] result = new int[Int256Math.NUM_WORDS];
		Int256Math.hexToUint(hex, result, 0);
		return result;
	}
}
