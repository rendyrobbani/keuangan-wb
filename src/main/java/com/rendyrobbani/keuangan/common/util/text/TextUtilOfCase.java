package com.rendyrobbani.keuangan.common.util.text;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class TextUtilOfCase {

	private static final List<String> UPPERCASE = List.of(
			"ASN",
			"APBD",
			"BBNKB",
			"BLUD",
			"BOK",
			"BOS",
			"BOSP",
			"BPHTB",
			"BTT",
			"BUD",
			"DAK",
			"DAU",
			"DBH",
			"DBHCHT",
			"DID",
			"DPA",
			"DPRD",
			"IF",
			"JHT",
			"JKK",
			"JKM",
			"KB",
			"KDH",
			"KEHATI",
			"KS",
			"KSP",
			"KUA",
			"LLAJ",
			"LO",
			"MAA",
			"MBLB",
			"MHA",
			"NIK",
			"NIP",
			"P3K",
			"PAD",
			"PBBP2",
			"PBJT",
			"PDN",
			"PHA",
			"PKB",
			"PNS",
			"PPAS",
			"PPKD",
			"PPLH",
			"PPPK",
			"PSU",
			"PTKP",
			"RAK",
			"RKA",
			"RKPD",
			"RPJMD",
			"RPJPD",
			"SDA",
			"SDM",
			"SEKDA",
			"SETDA",
			"SIPD",
			"SKPD",
			"SKPKD",
			"SPM",
			"TAPD",
			"TER",
			"TKDN",
			"TMT",
			"TPK",
			"TPP",
			"TTD",
			"TTL",
			"UMKM",
			"USP",
			"WKDH"
	                                                     );

	private final static List<String> LOWERCASE = List.of(
			"antar",
			"antara",
			"atas",
			"atau",
			"bagi",
			"berdasarkan",
			"dalam",
			"dan",
			"dari",
			"dengan",
			"di",
			"ke",
			"kepada",
			"melalui",
			"oleh",
			"pada",
			"sebagai",
			"secara",
			"sesuai",
			"serta",
			"terhadap",
			"tentang",
			"untuk",
			"yang"
	                                                     );

	private final static Map<String, String> IGNORECASE = Map.<String, String>ofEntries(
			Map.entry(" dan/Atau ", " dan/atau "),
			Map.entry(" Dan/atau ", " dan/atau "),
			Map.entry(" Dan/Atau ", " dan/atau "),
			Map.entry(" DAN/ATAU ", " dan/atau "),
			Map.entry("\\(Delapan\\)", "(delapan)"),
			Map.entry("\\(DELAPAN\\)", "(delapan)"),
			Map.entry("\\(Dua\\)", "(dua)"),
			Map.entry("\\(DUA\\)", "(dua)"),
			Map.entry("\\(Empat\\)", "(empat)"),
			Map.entry("\\(EMPAT\\)", "(empat)"),
			Map.entry("\\(Enam\\)", "(enam)"),
			Map.entry("\\(ENAM\\)", "(enam)"),
			Map.entry("\\(Lima\\)", "(lima)"),
			Map.entry("\\(LIMA\\)", "(lima)"),
			Map.entry("\\(Satu\\)", "(satu)"),
			Map.entry("\\(SATU\\)", "(satu)"),
			Map.entry("\\(Sembilan\\)", "(sembilan)"),
			Map.entry("\\(SEMBILAN\\)", "(sembilan)"),
			Map.entry("\\(Sepuluh\\)", "(sepuluh)"),
			Map.entry("\\(SEPULUH\\)", "(sepuluh)"),
			Map.entry("\\(Tiga\\)", "(tiga)"),
			Map.entry("\\(TIGA\\)", "(tiga)"),
			Map.entry("\\(Tujuh\\)", "(tujuh)"),
			Map.entry("\\(TUJUH\\)", "(tujuh)"),
			Map.entry("bagi hasil", "Bagi Hasil"),
			Map.entry("bagi Hasil", "Bagi Hasil"),
			Map.entry("Bagi hasil", "Bagi Hasil"),
			Map.entry("BAGI HASIL", "Bagi Hasil"),
			Map.entry("Bemotor", "Bermotor"),
			Map.entry("antar Air", "Antar Air"),
			Map.entry("antar air", "Antar Air"),
			Map.entry("ANTAR AIR", "Antar Air"),
			Map.entry("antar Daerah", "Antar Daerah"),
			Map.entry("antar daerah", "Antar Daerah"),
			Map.entry("ANTAR DAERAH", "Antar Daerah"),
			Map.entry("antar Kabupaten", "Antar Kabupaten"),
			Map.entry("antar kabupaten", "Antar Kabupaten"),
			Map.entry("ANTAR KABUPATEN", "Antar Kabupaten"),
			Map.entry("antar Kota", "Antar Kota"),
			Map.entry("antar kota", "Antar Kota"),
			Map.entry("ANTAR KOTA", "Antar Kota"),
			Map.entry("antar Negeri", "Antar Negeri"),
			Map.entry("antar negeri", "Antar Negeri"),
			Map.entry("ANTAR NEGERI", "Antar Negeri"),
			Map.entry("antar Pengerjaan", "Antar Pengerjaan"),
			Map.entry("antar pengerjaan", "Antar Pengerjaan"),
			Map.entry("ANTAR PENGERJAAN", "Antar Pengerjaan"),
			Map.entry("antar Proses", "Antar Proses"),
			Map.entry("antar proses", "Antar Proses"),
			Map.entry("ANTAR PROSES", "Antar Proses"),
			Map.entry("antar Provinsi", "Antar Provinsi"),
			Map.entry("antar provinsi", "Antar Provinsi"),
			Map.entry("ANTAR PROVINSI", "Antar Provinsi"),
			Map.entry("antar Renovasi", "Antar Renovasi"),
			Map.entry("antar renovasi", "Antar Renovasi"),
			Map.entry("ANTAR RENOVASI", "Antar Renovasi"),
			Map.entry("dalam Air", "Dalam Air"),
			Map.entry("dalam air", "Dalam Air"),
			Map.entry("DALAM AIR", "Dalam Air"),
			Map.entry("dalam Daerah", "Dalam Daerah"),
			Map.entry("dalam daerah", "Dalam Daerah"),
			Map.entry("DALAM DAERAH", "Dalam Daerah"),
			Map.entry("dalam Kabupaten", "Dalam Kabupaten"),
			Map.entry("dalam kabupaten", "Dalam Kabupaten"),
			Map.entry("DALAM KABUPATEN", "Dalam Kabupaten"),
			Map.entry("dalam Kota", "Dalam Kota"),
			Map.entry("dalam kota", "Dalam Kota"),
			Map.entry("DALAM KOTA", "Dalam Kota"),
			Map.entry("dalam Negeri", "Dalam Negeri"),
			Map.entry("dalam negeri", "Dalam Negeri"),
			Map.entry("DALAM NEGERI", "Dalam Negeri"),
			Map.entry("dalam Pengerjaan", "Dalam Pengerjaan"),
			Map.entry("dalam pengerjaan", "Dalam Pengerjaan"),
			Map.entry("DALAM PENGERJAAN", "Dalam Pengerjaan"),
			Map.entry("dalam Proses", "Dalam Proses"),
			Map.entry("dalam proses", "Dalam Proses"),
			Map.entry("DALAM PROSES", "Dalam Proses"),
			Map.entry("dalam Provinsi", "Dalam Provinsi"),
			Map.entry("dalam provinsi", "Dalam Provinsi"),
			Map.entry("DALAM PROVINSI", "Dalam Provinsi"),
			Map.entry("dalam Renovasi", "Dalam Renovasi"),
			Map.entry("dalam renovasi", "Dalam Renovasi"),
			Map.entry("DALAM RENOVASI", "Dalam Renovasi"),
			Map.entry("Ksp/Usp", "KSP/USP"),
			Map.entry("Nondestructive", "Non Destructive"),
			Map.entry("Olah Raga", "Olahraga"),
			Map.entry("Pangatur", "Pengatur"),
			Map.entry("Pengeloaan", "Pengelolaan"),
			Map.entry("PPh", "PPh"),
			Map.entry("Praktek", "Praktik"),
			Map.entry("Subskpd", "SubSKPD"),
			Map.entry("subSKPD", "SubSKPD"),
			Map.entry("SUBSKPD", "SubSKPD")
	                                                                                   );

	public static String toTitleCase(String text,
	                                 Map<String, String> replaceBefore,
	                                 Map<String, String> replaceAfter) {
		if (text == null || text.isBlank()) return text;

		String from = text;
		if (replaceBefore != null) {
			for (var entry : replaceBefore.entrySet()) {
				from = from.replace(entry.getKey(), entry.getValue());
			}
			from = from.trim();
		}

		List<String> result = new ArrayList<>();
		Matcher matcher = Pattern.compile("([^ -/]+)|([ -/]+)").matcher(from);

		while (matcher.find()) {
			String word = matcher.group(1);
			String separator = matcher.group(2);

			if (word != null) {
				String cleanWord = word.replaceAll("^[\\p{Punct}]+|[\\p{Punct}]+$", "");
				String leading = word.substring(0, word.indexOf(cleanWord));
				String trailing = word.substring(word.indexOf(cleanWord) + cleanWord.length());

				String transformed;
				if (UPPERCASE.contains(cleanWord.toUpperCase())) transformed = cleanWord.toUpperCase();
				else if (LOWERCASE.contains(cleanWord.toLowerCase())) transformed = cleanWord.toLowerCase();
				else transformed = cleanWord.isEmpty() ? "" : cleanWord.substring(0, 1).toUpperCase() + cleanWord.substring(1);

				result.add(leading + transformed + trailing);
			} else {
				result.add(separator);
			}
		}

		String into = String.join("", result);
		for (var uppercase : UPPERCASE) {
			var s = "Non" + uppercase.substring(0, 1).toLowerCase() + uppercase.substring(1);
			var r = "Non" + uppercase;
			while (into.contains(s)) into = into.replace(s, r);
		}
		for (var key : IGNORECASE.keySet()) while (into.contains(key)) into = into.replace(key, IGNORECASE.get(key));

		if (replaceAfter != null) {
			for (var entry : replaceAfter.entrySet()) {
				into = into.replace(entry.getKey(), entry.getValue());
			}
			into = into.trim();
		}

		return into.trim();
	}

	public static String toCamelCase(String text,
	                                 Map<String, String> replaceBefore,
	                                 Map<String, String> replaceAfter) {
		if (text == null || text.isBlank()) return text;

		var into = toTitleCase(text, replaceBefore, replaceAfter);
		return into.matches("^[A-Z0-9]*$") ? into : into.substring(0, 1).toLowerCase() + into.substring(1);
	}

}