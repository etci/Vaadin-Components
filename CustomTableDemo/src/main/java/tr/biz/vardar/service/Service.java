/**
 *
 */
package tr.biz.vardar.service;

/**
 * @author KUTAY
 *
 */
public interface Service<T> {
	public T newInstance();
	public void save(T t);
	public void edit(T t);
	public void delete(T t);
}
