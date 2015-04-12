package net.ivorius.planefighter;

// Due to a lack of server LWJGL, this is copied from LWJGL Matrix3f. Please note that this bit is not my work.
public class Matrix3f
{
	public float m00, m01, m02, m10, m11, m12, m20, m21, m22;

	public static Matrix3f mul( Matrix3f left, Matrix3f right, Matrix3f dest )
	{
		if (dest == null)
			dest = new Matrix3f();

		float m00 = left.m00 * right.m00 + left.m10 * right.m01 + left.m20 * right.m02;
		float m01 = left.m01 * right.m00 + left.m11 * right.m01 + left.m21 * right.m02;
		float m02 = left.m02 * right.m00 + left.m12 * right.m01 + left.m22 * right.m02;
		float m10 = left.m00 * right.m10 + left.m10 * right.m11 + left.m20 * right.m12;
		float m11 = left.m01 * right.m10 + left.m11 * right.m11 + left.m21 * right.m12;
		float m12 = left.m02 * right.m10 + left.m12 * right.m11 + left.m22 * right.m12;
		float m20 = left.m00 * right.m20 + left.m10 * right.m21 + left.m20 * right.m22;
		float m21 = left.m01 * right.m20 + left.m11 * right.m21 + left.m21 * right.m22;
		float m22 = left.m02 * right.m20 + left.m12 * right.m21 + left.m22 * right.m22;

		dest.m00 = m00;
		dest.m01 = m01;
		dest.m02 = m02;
		dest.m10 = m10;
		dest.m11 = m11;
		dest.m12 = m12;
		dest.m20 = m20;
		dest.m21 = m21;
		dest.m22 = m22;

		return dest;
	}

	public static Vector3f transform( Matrix3f left, Vector3f right, Vector3f dest )
	{
		if (dest == null)
			dest = new Vector3f();

		float x = left.m00 * right.x + left.m10 * right.y + left.m20 * right.z;
		float y = left.m01 * right.x + left.m11 * right.y + left.m21 * right.z;
		float z = left.m02 * right.x + left.m12 * right.y + left.m22 * right.z;

		dest.x = x;
		dest.y = y;
		dest.z = z;

		return dest;
	}
}
