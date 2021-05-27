package net.moznion.wireguard.keytool;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WireGuardKeyTest {
	@Test
	void shouldGenerateKeySuccessfully() throws Exception {
		final WireGuardKey generatedKey = WireGuardKey.generate();
		assertThat(generatedKey.getPrivateKey()).isNotEmpty();
		assertThat(generatedKey.getPublicKey()).isNotEmpty();
		assertThat(generatedKey.getBase64PrivateKey()).isNotEmpty();
		assertThat(generatedKey.getBase64PublicKey()).isNotEmpty();

		assertThat(WireGuardKey.isValidKey(generatedKey.getPrivateKey())).isTrue();
		assertThat(WireGuardKey.isValidKey(generatedKey.getPublicKey())).isTrue();
	}

	@Test
	void shouldBeInvalidKey() throws Exception {
		assertThat(WireGuardKey.isValidKey(new byte[]{})).isFalse();
	}

	@Test
	void shouldKeyPairsBeLegit() throws Exception {
		final List<TestData> testDataList = Arrays.asList(
			new TestData(
				"SJpNqu7Q+FiRug15SErCEhCfy0KtKjS+poABm0QeZm0=",
				"78HXdjfzBTLMTgEk3fSrKcT2wwgnvjEX1UoUVSjGBxo="
			),
			new TestData(
				"sLoZC2t4+WlS+qcsikC4hHq9ad2tsyxrtye47AxCsFw=",
				"xuCpDgABWe3I89RbH+yqsmXbWBlBfkvLzwRPOuMlTy4="
			),
			new TestData(
				"QHldkaRAnMzlCZLlYiGOuPrkCcCVmhe2qIOAEecJI2M=",
				"l7OVcn75s2rQDT4w4A/2fZ2GHW3sgvWv/nVi1zvFZgs="
			),
			new TestData(
				"qOy1PaL5ed9vjg5/Rz6qOFFnlboO3OmziX95dKBUW3c=",
				"hoBIJz6y8kynH/MBgbjIz9sJZrSGWSSZj0duUHshvFg="
			),
			new TestData(
				"WOOktHrKeTlKbjx3OPrG1R/96ufBJKq2FMwkGYqUuk0=",
				"OHktY4byMz/yPxxNBnMNAA8xM+dXIdNGrTvhZxENYmY="
			),
			new TestData(
				"yCXJXCJiwXcaP5JA8AvROs7h8f7hDBKifIpEsA9VCXM=",
				"hrXHVsBjz+9BnXLtrWJjIDAPYt7t6iXcpOuSRZVRBl0="
			),
			new TestData(
				"4GeLxNWIHhkgUvpCKBl0z9WxrRBmTnfvntOnnQrCPmE=",
				"SvTH62auxx46DH154xs9hosmuym2ylMAtgvfKZ3wqF8="
			),
			new TestData(
				"yL3vsL9LtqxZrh4xdwwQpFKhfbFjLMJIddfN+ZLKXlA=",
				"S0CPUNpE9snocivFRpehDLoYjSRi9iyy1xMvLbUSWX4="
			),
			new TestData(
				"IO6LqjHKrmEh8OZ6o9YMd+pHsL94Q3LjX/0mGHwsfWU=",
				"7bU45Y3XZ3LQC3iLr7N9feGVx+CUwnuFlknq705sfHk="
			),
			new TestData(
				"EBS8ZGY4iuk7roSqwz8991q1p07wR+pMP4xdE/LHG18=",
				"wqjFttLy6QUmpxtBMr/hw/wjvxf+4CK2sRc0Vk0qLws="
			),
			new TestData(
				"IJxDJ5HOcxfEoLU029//R2v3FpeEKCjUu1ahfYssin8=",
				"yhdoo2PCtBw9AKW1DO7AK/ZlKudgVJL5hLLznkGdzy4="
			),
			new TestData(
				"cEEHR/iLwbt7SK6JjiAtyMMjl9CI5kyR6ypzWLwqtEY=",
				"8fEaiHu/uYHQMeXXvMOhGtq6shLs/mZnZIka03vwb1Y="
			),
			new TestData(
				"WM5IJZM70Jqs+lV0HQ8lTMX1yPxjr4GYYuRe8tOXwHs=",
				"xETgq+ITDTY95YDHDjM76eHMI3CA5s3Zp9GyuNA+iRU="
			),
			new TestData(
				"aDC6DzAZyXy+9kHNVbHtju9A8HzYvGpZ+BxIV+SOjE8=",
				"QUmEo7vY7go1evxo6VlLmeeii3S0GWYl4FoXUu0xwHE="
			),
			new TestData(
				"aP/2cofcqMBToWvIXmeZQuJYAhPyAC+XxpL7nvBp2lU=",
				"2nzUibHmR/IRyqhr1GA87u3hrbMTeQUQzMUTt2WVEnk="
			),
			new TestData(
				"YDf1Y/d2hVi08w7ciJ42tN+2nqstN5goADq5DA6fnXU=",
				"CLoZlLZDYQp5TeQvMxpByIRJhc7vK9efaLoxnCG+bQ8="
			),
			new TestData(
				"mHkdiXwj28pDfbCeQseMPV48Xfzg3vaSOt05YhEZKlo=",
				"iDo5geyHDQrzV6ixyKbAY6dhNX89NfrrFMq8T/X78DM="
			),
			new TestData(
				"YD5u9vbpP2u6yMz+jLuBWXwmEmKQSGyorJDxxyPctFY=",
				"EeKDuyVHKqk5yOYVsUeixLEyvcVzEVNpReljJXotdQo="
			),
			new TestData(
				"yMmfYdLM3cFBmSMi3lfYyd1LF80t6BbtRBiYTLmGiW4=",
				"Q6lZIM9FJ5YMHNYJ6HRue3Bgh1mfaoNNHYxP+W8OPGc="
			),
			new TestData(
				"CAEUq5T5MjHKzsi7oyqvg3glCKB2DtrD9F0/lE02lWc=",
				"wOHrW7R8eUCIPmXI3Ng4bigmNbPyMV4T9uCZbFt1t1g="
			),
			new TestData(
				"ABh4dq4iI4QmN8t6a7G8QxvNzjWsFmKEOcgFAa4R92g=",
				"4BhofcRxZobPQeMYDTEBUSoRHpx/vGcAFwVTcsPyzUI="
			),
			new TestData(
				"CGUHIewz90qeVW2XUmB2C1AyiF3KK1Pi5euaiZ0B2Ho=",
				"Qw9V6DTpMPpNZSIH1Pfi/n6m0M1DdCW0Ous/+7fR7gk="
			),
			new TestData(
				"8MCIPaf0Z5OH0JX8oWzU1XnDDvQibujSxt7K8woyA3c=",
				"lJpPLBgyD/S7evRgLTUUNQ8W0pHCA3Ayvl8ExRXYcQ8="
			),
			new TestData(
				"AIniDY2bU3S6OC5DF8nOwgkskk6kRdR+l0aKyod+wF0=",
				"EdNZuQcg3ikAcs+uqZD8/mUEBTfVXqx9IM9LkLXJbmY="
			),
			new TestData(
				"uNEhF324szCRW9dTgLKMucJBlIqdTDqIob007EiJYHg=",
				"bqB1GYBube9A1WBeFsc1HcHeM/l3pHh/70k08eSJJnk="
			),
			new TestData(
				"mF7qSZhfB37o3HZ5rhpoA/f4BZUrZ4L1/+UX9UeaC2I=",
				"iuvM6/ScsIvREvoPMwfamvqeYO2xFGahqv4ZX9fy8wg="
			),
			new TestData(
				"CMOdfjb3YUcWWi2gL7XsKeefGBjFr3dpe/0xT8wSr2o=",
				"ESxte/9n28umGBeQx5ZNiiarQbFXDeFZKQBAAIL3TSc="
			),
			new TestData(
				"6Agr/ahVoF3ygnviWzr1saG+O6JBd1ib+zWAaHfaz2E=",
				"Lwb7DJxLwlwRwKyDjqgTMtgEiO8Be8tff7I7cPFrVUI="
			),
			new TestData(
				"kOyQ7GNEHCo1g7t1UM0Upg6JiYkNEfBwPJM4tKwIrFk=",
				"dyS4fvxmHX92VFJykBMv1OO0cWYD87sNRoXcHe1vSh8="
			),
			new TestData(
				"KClbxgf8NNbo6kplFZOeigZPxNC3nRURg0845CdQk1Y=",
				"9fmfDjx9ZF3hsFxssnnT/ANuYAKuKIy+CGOO6BuYZGI="
			)
		);

		for (TestData testData : testDataList) {
			final WireGuardKey wireGuardKey = new WireGuardKey(testData.inputBase64PrivateKey);
			assertThat(wireGuardKey.getBase64PublicKey())
				.isEqualTo(testData.expectedBase64PublicKey);
		}
	}

	@Test
	void shouldRaiseInvalidPrivateKeyException() throws Exception {
		assertThrows(InvalidPrivateKeyException.class, () -> new WireGuardKey("").getPublicKey());
	}

	private static class TestData {
		String inputBase64PrivateKey;
		String expectedBase64PublicKey;

		TestData(final String inputBase64PrivateKey, final String expectedBase64PublicKey) {
			this.inputBase64PrivateKey = inputBase64PrivateKey;
			this.expectedBase64PublicKey = expectedBase64PublicKey;
		}
	}
}
