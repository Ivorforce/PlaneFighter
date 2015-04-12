package net.ivorius.planefighter;

//Due to a lack of server LWJGL, this is copied from LWJGL Matrix3f. Please note that this bit is not my work.
public class Vector3f
{
	public float x, y, z;

	public Vector3f()
	{

	}

	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static float dot( Vector3f left, Vector3f right )
	{
		return left.x * right.x + left.y * right.y + left.z * right.z;
	}
}
