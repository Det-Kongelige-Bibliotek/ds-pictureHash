package dk.kb.api.webservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApiServiceImplTest {



    @Test
    void getImageDHash() {
        String url = "http://kb-images.kb.dk/DAMJP2/online_master_arkiv/non-archival/KOB/bs_kistebilleder-2/bs000001/full/!345,2555/0/native.jpg";
        ApiServiceImpl tester = new ApiServiceImpl();
        String result = tester.getImageDHash(url).toString();
        Assertions.assertEquals(true, result.contains("message: 379723421694405058899193996058950688972138258217989017426890367"));
        url = "https://kb-images.kb.dk/DAMJP2/online_master_arkiv/non-archival/KOB/bs_kistebilleder-2/bs000001/full/!345,2555/0/native.jpg";
        result = tester.getImageDHash(url).toString();
        Assertions.assertEquals(true, result.contains("message: null"));
        result = tester.getImageDHash(null).toString();
        Assertions.assertEquals(true, result.contains("message: null"));
        result = tester.getImageDHash("").toString();
        Assertions.assertEquals(true, result.contains("message: null"));
        result = tester.getImageDHash("https://test").toString();
        Assertions.assertEquals(true, result.contains("message: null"));
    }

    @Test
    void getImagePHash() {
        String url = "http://kb-images.kb.dk/DAMJP2/online_master_arkiv/non-archival/KOB/bs_kistebilleder-2/bs000001/full/!345,2555/0/native.jpg";
        ApiServiceImpl tester = new ApiServiceImpl();
        String result = tester.getImagePHash(url).toString();
        Assertions.assertEquals(true, result.contains("message: 17667239340915791203"));
        url = "https://kb-images.kb.dk/DAMJP2/online_master_arkiv/non-archival/KOB/bs_kistebilleder-2/bs000001/full/!345,2555/0/native.jpg";
        result = tester.getImagePHash(url).toString();
        Assertions.assertEquals(true, result.contains("message: null"));
        result = tester.getImagePHash(null).toString();
        Assertions.assertEquals(true, result.contains("message: null"));
        result = tester.getImagePHash("").toString();
        Assertions.assertEquals(true, result.contains("message: null"));
        result = tester.getImagePHash("https://test").toString();
        Assertions.assertEquals(true, result.contains("message: null"));
    }

    @Test
    void getHashDistance() {
        ApiServiceImpl tester = new ApiServiceImpl();
        String result = "";
        result = tester.getHashDistance("4;1").toString();
        Assertions.assertEquals(true, result.contains("message: 2"));
        result = tester.getHashDistance("-4;1").toString();
        Assertions.assertEquals(true, result.contains("message: Both hash values has to be positive"));
        result = tester.getHashDistance("4;-11").toString();
        Assertions.assertEquals(true, result.contains("message: Both hash values has to be positive"));
        result = tester.getHashDistance("-4;-11").toString();
        Assertions.assertEquals(true, result.contains("message: Both hash values has to be positive"));
        result = tester.getHashDistance("abc;def").toString();
        Assertions.assertEquals(true, result.contains("message: Both values has to be BigInteger separated by ; character"));
        result = tester.getHashDistance("abc;def;ghi").toString();
        Assertions.assertEquals(true, result.contains("message: Both values has to be BigInteger separated by ; character"));
        result = tester.getHashDistance("").toString();
        Assertions.assertEquals(true, result.contains("message: The two hash values has to be divided by ; character"));
        result = tester.getHashDistance(null).toString();
        Assertions.assertEquals(true, result.contains("message: The two hash values has to be divided by ; character"));
        result = tester.getHashDistance("4;;1").toString();
        Assertions.assertEquals(true, result.contains("message: Both values has to be BigInteger separated by ; character"));
        result = tester.getHashDistance("4;4").toString();
        Assertions.assertEquals(true, result.contains("message: 0"));
        result = tester.getHashDistance("4;;1").toString();
        Assertions.assertEquals(true, result.contains("message: Both values has to be BigInteger separated by ; character"));
        result = tester.getHashDistance("00100011;100011100").toString();
        Assertions.assertEquals(true, result.contains("message: 19"));
    }
}