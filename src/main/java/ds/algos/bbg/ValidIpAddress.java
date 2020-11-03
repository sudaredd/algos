package ds.algos.bbg;

/**
 * Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
 * <p>
 * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros.
 * For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.
 * <p>
 * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
 * <p>
 * 1 <= xi.length <= 4
 * xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
 * Leading zeros are allowed in xi.
 * For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses,
 * while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 */
public class ValidIpAddress {

    public static void main(String[] args) {
        ValidIpAddress validIpAddress = new ValidIpAddress();
        System.out.println(validIpAddress.validIPAddress("192.168.1.1"));
        System.out.println(validIpAddress.validIPAddress("192.168.1.0"));
        System.out.println(validIpAddress.validIPAddress("192.168.01.1"));
        System.out.println(validIpAddress.validIPAddress("192.168.1.00"));
        System.out.println(validIpAddress.validIPAddress("192.168.@1.0"));
        System.out.println(validIpAddress.validIPAddress("1.0.1."));

        System.out.println("end IPv4");

        System.out.println(validIpAddress.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(validIpAddress.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIpAddress.validIPAddress("2001:0db8:85a3::8A2E:037j:7334"));
        System.out.println(validIpAddress.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(validIpAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

    }

    public String validIPAddress(String IP) {
        if (IP.indexOf('.') >= 0) {
            return validateIpv4(IP);
        } else if (IP.indexOf(':') >= 0) {
            return validateIpv6(IP);
        } else {
            return "Neither";
        }
    }

    private String validateIpv6(String ip) {
        String[] split = ip.split(":", -1);
        if (split == null || split.length != 8) {
            return "Neither";
        }
        for (String str : split) {
            if(str.trim().equals("") || str.length() <0 || str.length() > 4) {
                return "Neither";
            }

            for(char c : str.toCharArray()) {
                if(Character.isUpperCase(c)) {
                    if(!(c >= 'A' && c <='F')) {
                        return "Neither";
                    }
                } else if(Character.isLowerCase(c)) {
                    if(!(c >= 'a' && c <='f')) {
                        return "Neither";
                    }
                } else if(!(c-'0' >=0 && c-'0'<=9 )) {
                    return "Neither";
                }
            }
        }
        return "IPv6";

    }

    private String validateIpv4(String ip) {

        String[] split = ip.split("\\.", -1);
        if (split == null || split.length != 4) {
            return "Neither";
        }
        for (String str : split) {
            if (str.trim().equals("") || (str.length() <0 || str.length() > 3) || (str.startsWith("0") && str.length() > 1))
                return "Neither";

            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c))
                    return "Neither";
            }

            int num = Integer.parseInt(str);
            if (num < 0 || num > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }
}
